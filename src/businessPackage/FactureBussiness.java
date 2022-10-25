package businessPackage;

import dataAccessPackage.FactureDB;
import exceptionPackage.ConnexionException;
import modelPackage.Client;
import modelPackage.Facture;
import modelPackage.ModelRechercheFacture;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class FactureBussiness {

    private FactureDB dao;

    public FactureBussiness() throws ConnexionException{
        setDao(new FactureDB());
    }

    public void setDao(FactureDB dao) {
        this.dao = dao;
    }

    public ArrayList<Facture> getEnsembleFacture() throws ConnexionException{
        return new FactureDB().getEsembleFacture();
    }

    public ArrayList<ModelRechercheFacture> getFacture2Date(Client client, GregorianCalendar dateDeb, GregorianCalendar dateFin) throws ConnexionException{
        return dao.getFacture2Date(client,dateDeb,dateFin);
    }




}
