package dataAccessPackage;


import exceptionPackage.*;
import modelPackage.Client;
import modelPackage.Etablissement;
import modelPackage.Facture;

import java.sql.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class ClientDB implements ClientDAO
{

    private Connection connection ;

    public ClientDB()throws ConnexionException
    {
        setConnection(SingletonConnection.getInstance());
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }


@Override
   public  ArrayList<Client> getEnsembleClient() throws  ConnexionException, VilleException, CodePostalException, NomException, PrenomException,RueException,NumeroException,DateNaissanceException,IdentifiantException,TelephoneException,EmailException
   {
        try
        {
            PreparedStatement requeteSql = connection.prepareStatement("select  * from client");

            ResultSet res  = requeteSql.executeQuery();
            ArrayList<Client> clients = new ArrayList<>();

            java.sql.Date sqlDate ;

            while(res.next())
            {
                GregorianCalendar calendar = new GregorianCalendar();
               calendar.setTime(res.getDate(9));
               clients.add(new Client(res.getString("Identifiant"),res.getInt("EtablissementMatricule"),res.getString("Nom"),res.getString("Prenom"),res.getString("CodePostal"),res.getString("Ville"),res.getString("Rue"),res.getString("Numero"),calendar,res.getString("Telephone"),res.getString("Email"),res.getBoolean("CarteFidelite"),res.getDouble("TailleLunette"),res.getDouble("TailleCeinture"),res.getString("TailleVetement")));

            }
            return clients;
        }
        catch (SQLException sqlException)
        {
            throw  new ConnexionException();
        }

   }

   public Etablissement obtentionEtablissement(Integer matriculeRecus)throws ConnexionException
   {
       Integer matricule;
       String nom;
       String adresse;
       String telephone;
       String email;

       try
       {

           PreparedStatement sql = connection.prepareStatement("select * from etablissement where = ?");
           sql.setInt(1, matriculeRecus);

           ResultSet donnee = sql.executeQuery();


           donnee.next();

           matricule = donnee.getInt("Matricule");
           nom = donnee.getString("Nom");
           adresse = donnee.getString("Adresse");
           telephone = donnee.getString("Telephone");
           email = donnee.getString("Email");

            return new Etablissement(matricule,nom,adresse,telephone,email);

       }
       catch (SQLException sqlException)
       {

           throw new ConnexionException();
       }
   }

   public void supprimerClient(String identifiant)throws ConnexionException
   {

       try
       {
           supprimerLienFacture(identifiant);

          PreparedStatement statement = connection.prepareStatement("delete from client where Identifiant = ? ");

          statement.setString(1, identifiant);

           statement.executeUpdate();
       }
       catch (SQLException e)
       {
           throw new ConnexionException();
       }

   }

    public void supprimerLienFacture(String identifiant)throws ConnexionException {

        int numeroFactureASupprimer;


        try
        {

            ArrayList<Facture>  listeFacture = rechercheNumeroFacture(identifiant);

            Integer  nbFactureASupprimer = listeFacture.size();


                for (int i = 0; i < nbFactureASupprimer; i++) {
                    numeroFactureASupprimer = listeFacture.get(i).getNumero();
                    supprimerLienGoodie(numeroFactureASupprimer);
                    supprimerLienExemplaire(numeroFactureASupprimer);

                }

                 PreparedStatement statement = connection.prepareStatement("delete from facture where  ClientIdentifiant = ?");
                 statement.setString(1, identifiant);
                 statement.executeUpdate();
        }
        catch (SQLException e)
        {
            throw new ConnexionException();
        }
    }

    public ArrayList<Facture> rechercheNumeroFacture(String identifiant)throws ConnexionException
    {
        try
        {
            ArrayList<Facture>  listeFacture = new ArrayList<>();

            PreparedStatement sql = connection.prepareStatement("select Numero from facture where ClientIdentifiant = ?");
            sql.setString(1, identifiant);
            ResultSet donnee = sql.executeQuery();

            while(donnee.next()) {
                listeFacture.add(new Facture(donnee.getInt(1)));

            }
            return listeFacture;
        }
        catch (SQLException e)
        {
            throw new ConnexionException();
        }
    }

    public void supprimerLienGoodie(int numeroFacture)throws ConnexionException {
        try
        {
            PreparedStatement statement = connection.prepareStatement("delete from goodie where  FactureNumero = ?");
            statement.setInt(1,numeroFacture);

            statement.executeUpdate();
        }
        catch (SQLException e)
        {
            throw new ConnexionException();
        }
    }

    public void supprimerLienExemplaire(int numeroFactureASupprimer)throws ConnexionException {

        try
        {

            PreparedStatement statement = connection.prepareStatement("delete from exemplaire where ( FactureNumero = ?)");
            statement.setInt(1,numeroFactureASupprimer);

            statement.executeUpdate();

        }
        catch (SQLException e)
        {
            throw new ConnexionException();
        }

    }


    public void modifierClient(Client clientAModifier)throws ConnexionException
    {
        try
        {
            String requeteSQL = "update client set EtablissementMatricule = ?,Nom = ?,Prenom = ?,CodePostal = ?,Ville = ?,Rue = ?,Numero  = ?,DateNaissance = ?,Telephone = ?,Email = ?,CarteFidelite = ?,TailleLunette = ?,TailleCeinture = ?,TailleVetement = ?  where Identifiant = '"+clientAModifier.getIdentifiant()+"'";
            PreparedStatement statement = connection.prepareStatement(requeteSQL);

            java.sql.Date sqlDateNaissance = new java.sql.Date(clientAModifier.getDateNaissance().getTimeInMillis());


            statement.setInt(1,clientAModifier.getMatricule());
            statement.setString(2,clientAModifier.getNom());
            statement.setString(3,clientAModifier.getPrenom());
            statement.setString(4,clientAModifier.getCodePostal());
            statement.setString(5,clientAModifier.getVille());
            statement.setString(6,clientAModifier.getRue());
            statement.setString(7,clientAModifier.getNumero());
            statement.setDate(8,sqlDateNaissance);

            statement.setNull(9, Types.VARCHAR);
            statement.setString(9,clientAModifier.getTelephone());

            statement.setNull(10, Types.VARCHAR);
            statement.setString(10,clientAModifier.getEmail());

            statement.setBoolean(11,clientAModifier.getCarteFidelite());

            statement.setNull(12,Types.DOUBLE);
            statement.setDouble(12,clientAModifier.getTailleLunette());

            statement.setNull(13,Types.DOUBLE);
            statement.setDouble(13,clientAModifier.getTailleCeinture());

            statement.setNull(14,Types.VARCHAR);
            statement.setString(14,clientAModifier.getTailleVetement());

            statement.executeUpdate();

        }catch (SQLException e)
        {
            throw new ConnexionException();
        }

    }


   public void ajouterClient(Client nouveauClient)throws ConnexionException,NomException,PrenomException, CodePostalException,VilleException,RueException,NumeroException,DateNaissanceException
   {

       try {

           PreparedStatement statement = connection.prepareStatement("insert into client (Identifiant, EtablissementMatricule, Nom, Prenom, CodePostal, Ville, Rue, Numero, DateNaissance, Telephone, Email, CarteFidelite, TailleLunette, TailleCeinture, TailleVetement) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");


           java.sql.Date sqlDateNaissance = new java.sql.Date(nouveauClient.getDateNaissance().getTimeInMillis());

           statement.setString(1,nouveauClient.getIdentifiant());
           statement.setInt(2,nouveauClient.getMatricule());
           statement.setString(3,nouveauClient.getNom());
           statement.setString(4,nouveauClient.getPrenom());
           statement.setString(5,nouveauClient.getCodePostal());
           statement.setString(6,nouveauClient.getVille());
           statement.setString(7,nouveauClient.getRue());
           statement.setString(8,nouveauClient.getNumero());
           statement.setDate(9,sqlDateNaissance);

           statement.setNull(10, Types.VARCHAR);
           statement.setString(10,nouveauClient.getTelephone());

           statement.setNull(11, Types.VARCHAR);
           statement.setString(11,nouveauClient.getEmail());

           statement.setBoolean(12,nouveauClient.getCarteFidelite());

           statement.setNull(13,Types.DOUBLE);
           statement.setDouble(13,nouveauClient.getTailleLunette());

           statement.setNull(14,Types.DOUBLE);
           statement.setDouble(14,nouveauClient.getTailleCeinture());

           statement.setNull(15,Types.VARCHAR);
           statement.setString(15,nouveauClient.getTailleVetement());


           statement.executeUpdate();
       }
       catch (SQLException exception)
       {
          throw new ConnexionException();
       }

   }

}
