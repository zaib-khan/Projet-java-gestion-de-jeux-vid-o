package dataAccessPackage;

import exceptionPackage.*;
import modelPackage.Client;
import modelPackage.Etablissement;
import modelPackage.Facture;

import java.util.ArrayList;

public interface ClientDAO {

  ArrayList<Client> getEnsembleClient() throws ConnexionException , VilleException, CodePostalException, NomException, PrenomException,RueException,NumeroException,DateNaissanceException,IdentifiantException,TelephoneException,EmailException;


    void ajouterClient(Client nouveauClient)throws ConnexionException,NomException,PrenomException, CodePostalException,VilleException,RueException,NumeroException,DateNaissanceException,IdentifiantException,TelephoneException,EmailException;

     ArrayList<Facture> rechercheNumeroFacture(String identifiant)throws ConnexionException;

    Etablissement obtentionEtablissement(Integer matriculeRecus)throws ConnexionException;


    void supprimerLienFacture(String identifiant)throws ConnexionException ;

     void supprimerClient(String identifiant)throws ConnexionException;

    void modifierClient(Client clientAModifier)throws ConnexionException;

     void supprimerLienGoodie(int numeroFacture)throws ConnexionException;
}
