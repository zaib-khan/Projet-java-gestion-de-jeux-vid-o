package dataAccessPackage;

import exceptionPackage.ConnexionException;
import modelPackage.Client;
import modelPackage.Facture;
import modelPackage.ModelRechercheFacture;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public interface FactureDAO {

     ArrayList<Facture> getEsembleFacture() throws ConnexionException ;

     ArrayList<ModelRechercheFacture> getFacture2Date(Client client, GregorianCalendar dateDeb, GregorianCalendar dateFin) throws ConnexionException;
}
