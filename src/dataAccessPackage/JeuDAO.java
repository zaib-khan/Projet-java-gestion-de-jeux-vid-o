package dataAccessPackage;

import exceptionPackage.ConnexionException;
import modelPackage.Client;
import modelPackage.Jeu;
import modelPackage.ModelRechercheJeuAchete;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public interface JeuDAO {

    ArrayList<ModelRechercheJeuAchete> getJeuClient(Client client, GregorianCalendar calendar) throws ConnexionException;

     ArrayList<Jeu> getEnsembleJeux()throws ConnexionException;

}