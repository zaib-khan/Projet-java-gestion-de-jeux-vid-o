package businessPackage;

import dataAccessPackage.EtablissementDAO;
import dataAccessPackage.EtablissementDB;
import exceptionPackage.ConnexionException;
import modelPackage.Etablissement;

import java.util.ArrayList;

public class EtablissementBussiness {

    private EtablissementDAO dao;

    public EtablissementBussiness() throws  ConnexionException
    {
        setDao(new EtablissementDB());
    }

    public void setDao(EtablissementDAO dao) {
        this.dao = dao;
    }

    public ArrayList<Etablissement> getEnsembleEtablissement() throws ConnexionException
    {
        return dao.getEnsembleEtablissement();
    }
}
