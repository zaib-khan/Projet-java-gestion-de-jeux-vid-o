package dataAccessPackage;

import exceptionPackage.ConnexionException;
import modelPackage.Client;
import modelPackage.ModelRechercheGoodie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class GoodieDB implements GoodieDAO{

    private Connection connection;

    public GoodieDB() throws ConnexionException {
        setConnection(SingletonConnection.getInstance());
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public ArrayList<ModelRechercheGoodie> getGoodieClient(Client client, GregorianCalendar calendar) throws ConnexionException {
        try{
            PreparedStatement statement = connection.prepareStatement("select g.Libelle, g.PrixBase, g.typeGoodie, f.DateFacture, v.Nom, v.Prenom\n" +
                    "from facture f, client c, goodie g, vendeur v \n" +
                    "where c.Identifiant = f.ClientIdentifiant \n" +
                    "and v.NumIdentifiant = f.VendeurNumIdentifiant \n" +
                    "and g.FactureNumero = f.Numero \n" +
                    "and c.Identifiant = ? \n" +
                    "and f.DateFacture > ? ");

            java.sql.Date sqlDate = new java.sql.Date(calendar.getTimeInMillis());


            statement.setString(1,client.getIdentifiant());
            statement.setDate(2,sqlDate);
            ResultSet resultSet = statement.executeQuery();

            ArrayList<ModelRechercheGoodie> listeGoodie = new ArrayList<>();


            while (resultSet.next()){

                GregorianCalendar date = new GregorianCalendar();
                date.setTime(resultSet.getDate("DateFacture"));

                listeGoodie.add(new ModelRechercheGoodie(resultSet.getString("Libelle"),resultSet.getDouble("PrixBase"),resultSet.getString("typeGoodie"),date,resultSet.getString("Nom"),resultSet.getString("Prenom")));
            }

            return listeGoodie;


        }
        catch (SQLException exception){
            throw new ConnexionException();
        }
    }
}