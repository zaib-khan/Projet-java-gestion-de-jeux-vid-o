package dataAccessPackage;

import exceptionPackage.ConnexionException;
import modelPackage.Etablissement;

import java.util.ArrayList;

public interface EtablissementDAO {


     ArrayList<Etablissement> getEnsembleEtablissement() throws ConnexionException;



}
