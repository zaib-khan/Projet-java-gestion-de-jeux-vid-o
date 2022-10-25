package controllerPackage;

import businessPackage.*;


import exceptionPackage.*;
import modelPackage.*;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Control {

    private ClientBussiness accesClientBussiness;

    public Control()throws ConnexionException
    {
        setAccesClientBussiness(new ClientBussiness());
    }




    public void setAccesClientBussiness(ClientBussiness accesClientBussiness) {
        this.accesClientBussiness = accesClientBussiness;
    }



    public ArrayList<Etablissement> getEnsembleEtablissement() throws ConnexionException
    {
        return new EtablissementBussiness().getEnsembleEtablissement();
    }

    public ArrayList<Facture> getEnsembleFacture() throws ConnexionException{
        return new FactureBussiness().getEnsembleFacture();
    }

    public void ajouterClient(Client nouveauClient)throws ConnexionException,NomException,PrenomException, CodePostalException,VilleException,RueException,NumeroException,DateNaissanceException,IdentifiantException,TelephoneException,EmailException
    {
        new ClientBussiness().ajouterClient(nouveauClient);
    }


    public  ArrayList<Client> getEnsembleClient() throws ConnexionException, VilleException, CodePostalException, NomException, PrenomException,RueException,NumeroException,DateNaissanceException,IdentifiantException,TelephoneException,EmailException
    {
        return new ClientBussiness().getEnsembleClient();
    }

    public void supprimerLienFacture(String identifiant)throws ConnexionException
    {
        try {
            accesClientBussiness.supprimerLienFacture(identifiant);
        }
        catch (ConnexionException e)
        {
            throw new ConnexionException();
        }
    }

    public void supprimerClient(String identifiant)throws ConnexionException
    {

        new ClientBussiness().supprimerClient(identifiant);
    }

    public void modifierClient(Client clientAModifier)throws ConnexionException
    {
        new ClientBussiness().modifierClient(clientAModifier);
    }



    public ArrayList<ModelRechercheJeuAchete> getJeuClient(Client client, GregorianCalendar calendar) throws ConnexionException{
        return new JeuBussiness().getJeuClient(client,calendar);
    }


    public ArrayList<ModelRechercheGoodie> getGoodieClient(Client client, GregorianCalendar calendar) throws ConnexionException {
        return new GoodieBussiness().getGoodieClient(client,calendar);
    }

    public ArrayList<ModelRechercheFacture> getFacture2Date(Client client, GregorianCalendar dateDeb, GregorianCalendar dateFin) throws ConnexionException{
        return new FactureBussiness().getFacture2Date(client,dateDeb,dateFin);
    }

    public Double  prixBaseMoyen()throws ConnexionException
    {
        return new JeuBussiness().prixBaseMoyen();
    }

    public Double  limiteAgeMoyenJeux()throws ConnexionException
    {
        return new JeuBussiness().limiteAgeMoyenJeux();
    }

}
