package dataAccessPackage;

import exceptionPackage.ConnexionException;
import modelPackage.Etablissement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EtablissementDB implements EtablissementDAO {

    private Connection connection;

    public EtablissementDB()throws  ConnexionException
    {

        setConnection(SingletonConnection.getInstance());
    }


    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public ArrayList<Etablissement> getEnsembleEtablissement() throws ConnexionException
    {
        try
        {
            ArrayList<Etablissement> etablissements = new ArrayList<>();

            PreparedStatement sql = connection.prepareStatement("select Matricule,Nom,Adresse,Telephone,Email from etablissement");
            ResultSet res = sql.executeQuery();

            while(res.next()){
                etablissements.add(new Etablissement(res.getInt(1), res.getString(2),res.getString(3),res.getString(4),res.getString(5)));
            }

            return etablissements;

        }
        catch (SQLException sqlException)
        {

            throw  new ConnexionException();
        }
    }
}
