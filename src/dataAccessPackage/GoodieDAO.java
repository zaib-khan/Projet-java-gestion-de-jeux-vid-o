package dataAccessPackage;

import exceptionPackage.ConnexionException;
import modelPackage.Client;
import modelPackage.ModelRechercheGoodie;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public interface GoodieDAO {


    ArrayList<ModelRechercheGoodie> getGoodieClient(Client client, GregorianCalendar calendar) throws ConnexionException;
}