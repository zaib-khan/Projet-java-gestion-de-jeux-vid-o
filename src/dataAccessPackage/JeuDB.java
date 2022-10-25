package dataAccessPackage;


import exceptionPackage.ConnexionException;
import modelPackage.Client;
import modelPackage.Jeu;
import modelPackage.ModelRechercheJeuAchete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class JeuDB implements JeuDAO {

    private Connection connection;

    public JeuDB() throws ConnexionException {
        setConnection(SingletonConnection.getInstance());
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }


    @Override
    public ArrayList<ModelRechercheJeuAchete> getJeuClient(Client client, GregorianCalendar calendar) throws ConnexionException {

        try{
            PreparedStatement statement = connection.prepareStatement("select j.Titre, e.Edition, j.Theme, j.AnneeSortie, j.LimiteAge, e.NumRayon, e.NumEtagere, f.DateFacture\n" +
                    "from client c , facture f , exemplaire e , jeu j \n" +
                    "where c.Identifiant = f.ClientIdentifiant \n" +
                    "and f.Numero = e.FactureNumero\n" +
                    "and e.JeuCode = j.Code\n" +
                    "and c.Identifiant = ? \n" +
                    "and f.DateFacture > ?");

            java.sql.Date sqlDate = new java.sql.Date(calendar.getTimeInMillis());


            statement.setString(1,client.getIdentifiant());
            statement.setDate(2,sqlDate);
            ResultSet resultSet = statement.executeQuery();


            ArrayList<ModelRechercheJeuAchete> listeJeu = new ArrayList<>(); //---------------------Correction ICI


            while (resultSet.next()){


                GregorianCalendar date = new GregorianCalendar();
                date.setTime(resultSet.getDate("DateFacture"));

                listeJeu.add(new ModelRechercheJeuAchete(resultSet.getString("Titre"),resultSet.getString("Edition"),resultSet.getString("Theme"),resultSet.getInt("AnneeSortie"),resultSet.getInt("LimiteAge"),
                        resultSet.getInt("NumRayon"),resultSet.getInt("NumEtagere"),date));
            }

            return listeJeu;


        }
        catch (SQLException exception){
            throw new ConnexionException();
        }



    }


    public ArrayList<Jeu> getEnsembleJeux()throws ConnexionException
    {
        try
        {
            PreparedStatement statement = connection.prepareStatement("Select * from jeu");
            ResultSet res = statement.executeQuery();
            ArrayList<Jeu> listeJeu = new ArrayList<>();

            while(res.next())
            {
                listeJeu.add(new Jeu( res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getDouble(5),res.getInt(6),res.getInt(7),res.getInt(8),res.getInt(9)));
            }

            return listeJeu;

        }catch (SQLException e)
        {
            throw new ConnexionException();
        }
    }
}