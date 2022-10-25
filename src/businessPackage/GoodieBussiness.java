package businessPackage;

import dataAccessPackage.GoodieDB;
import exceptionPackage.ConnexionException;
import modelPackage.Client;
import modelPackage.ModelRechercheGoodie;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class GoodieBussiness {

    private GoodieDB dao;


    public GoodieBussiness() throws ConnexionException {
        setDao(new GoodieDB());
    }

    public void setDao(GoodieDB dao) {
        this.dao = dao;
    }

    public ArrayList<ModelRechercheGoodie> getGoodieClient(Client client, GregorianCalendar calendar) throws ConnexionException {
        return new GoodieDB().getGoodieClient(client,calendar);
    }


}