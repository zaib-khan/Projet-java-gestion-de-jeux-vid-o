package businessPackage;

import dataAccessPackage.ClientDB;
import exceptionPackage.*;
import modelPackage.Client;

import java.util.ArrayList;

public class ClientBussiness {


    private ClientDB dao;

    public ClientBussiness()throws ConnexionException
    {
        setDao(new ClientDB());
    }

    public void setDao(ClientDB dao)
    {
        this.dao = dao;
    }

    public ArrayList<Client> getEnsembleEtablissement()throws ConnexionException, VilleException, CodePostalException, NomException, PrenomException,RueException,NumeroException,DateNaissanceException,IdentifiantException,TelephoneException,EmailException
    {
        return dao.getEnsembleClient();
    }


    public void ajouterClient(Client nouveauClient)throws ConnexionException,NomException,PrenomException, CodePostalException,VilleException,RueException,NumeroException,DateNaissanceException,IdentifiantException,TelephoneException,EmailException
    {


        new ClientDB().ajouterClient(nouveauClient);
    }


    public  ArrayList<Client> getEnsembleClient() throws ConnexionException, VilleException, CodePostalException, NomException, PrenomException,RueException,NumeroException,DateNaissanceException,IdentifiantException,TelephoneException,EmailException
    {
        return dao.getEnsembleClient();
    }

    public void supprimerLienFacture(String identifiant)throws ConnexionException
    {
        dao.supprimerLienFacture(identifiant);
    }

    public void supprimerClient(String identifiant)throws ConnexionException
    {

       dao.supprimerClient(identifiant);
    }

    public void modifierClient(Client clientAModifier)throws ConnexionException
    {
        dao.modifierClient(clientAModifier);
    }



}
