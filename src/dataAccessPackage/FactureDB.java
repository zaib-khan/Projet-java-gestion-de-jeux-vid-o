package dataAccessPackage;

import exceptionPackage.ConnexionException;
import modelPackage.Client;
import modelPackage.Facture;
import modelPackage.ModelRechercheFacture;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class FactureDB implements FactureDAO {

    private Connection connection;

    public FactureDB() throws ConnexionException{
        setConnection(SingletonConnection.getInstance());
    }

    public void setConnection(Connection connection){
        this.connection = connection;
    }

    @Override
    public ArrayList<Facture> getEsembleFacture() throws ConnexionException {

        try {
            PreparedStatement statement = connection.prepareStatement("select * from Facture");

            ResultSet resultSet = statement.executeQuery();

            ArrayList<Facture> factures = new ArrayList<>();

            //GregorianCalendar calendar = new GregorianCalendar();
            // java.sql.Date sqlDate = new java.sql.Date(calendar.getTimeInMillis( ));

            while (resultSet.next()){

                GregorianCalendar calendar = new GregorianCalendar();
                calendar.setTime(resultSet.getDate("DateFacture"));

                factures.add(new Facture(resultSet.getInt("Numero"),calendar,resultSet.getInt("VendeurNumIdentifiant"),resultSet.getString("ClientIdentifiant")));

            }

            return factures;


        }
        catch (SQLException sqlException){
            throw new ConnexionException();
        }
    }


    @Override
    public ArrayList<ModelRechercheFacture> getFacture2Date(Client client, GregorianCalendar dateDeb, GregorianCalendar dateFin) throws ConnexionException {
        try {
            PreparedStatement statement = connection.prepareStatement("select f.DateFacture, f.Numero, v.Nom, v.Prenom, e.Nom \n" +
                    "from facture f, client c, vendeur v, etablissement e \n" +
                    "where c.Identifiant = f.ClientIdentifiant \n" +
                    "and e.Matricule = v.EtablissementMatricule \n" +
                    "and v.NumIdentifiant = f.VendeurNumIdentifiant \n" +
                    "and c.Identifiant = ? \n" +
                    "and f.DateFacture > ? \n" +
                    "and f.DateFacture < ? ");

            java.sql.Date sqlDateDeb = new java.sql.Date(dateDeb.getTimeInMillis());
            java.sql.Date sqlDateFin = new java.sql.Date(dateFin.getTimeInMillis());

            statement.setString(1,client.getIdentifiant());
            statement.setDate(2,sqlDateDeb);
            statement.setDate(3,sqlDateFin);

            ResultSet resultSet = statement.executeQuery();

            ArrayList<ModelRechercheFacture> factures = new ArrayList<>();

            while (resultSet.next()){

                GregorianCalendar calendar = new GregorianCalendar();
                calendar.setTime(resultSet.getDate("DateFacture"));

                factures.add(new ModelRechercheFacture(calendar,resultSet.getInt("Numero"),resultSet.getString("Nom"),resultSet.getString("Prenom"),resultSet.getString(5)));

            }
            return factures;
        }
        catch (SQLException sqlException){
            throw new ConnexionException();
        }
    }
}







