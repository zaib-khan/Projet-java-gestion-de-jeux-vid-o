package businessPackage;

import dataAccessPackage.JeuDB;
import exceptionPackage.ConnexionException;
import modelPackage.Client;
import modelPackage.Jeu;
import modelPackage.ModelRechercheJeuAchete;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class JeuBussiness {

    private JeuDB dao;

    public JeuBussiness() throws ConnexionException {
        setDao(new JeuDB());
    }

    public void setDao(JeuDB dao) {
        this.dao = dao;
    }

    public ArrayList<ModelRechercheJeuAchete> getJeuClient(Client client, GregorianCalendar calendar) throws ConnexionException {
        return dao.getJeuClient(client, calendar);
    }


    public Double  limiteAgeMoyenJeux()throws ConnexionException
    {
        ArrayList<Jeu> listeJeux = new JeuDB().getEnsembleJeux();

        int nbJeux = listeJeux.size();

        double sommeLimiteAge = 0;
        double limiteMoyen;

        for(int i = 0; i < nbJeux; i++)
        {
            sommeLimiteAge += listeJeux.get(i).getLimiteAge();
        }

        if(nbJeux != 0) {
            limiteMoyen =  sommeLimiteAge / (double) nbJeux;
        }
        else {
            limiteMoyen = 0;
        }

        return limiteMoyen;

    }


    public Double prixBaseMoyen() throws  ConnexionException
    {
        ArrayList<Jeu> listeJeux = new JeuDB().getEnsembleJeux();

        int nbJeux = listeJeux.size();

        double sommePrixMoyen = 0;
        double prixMoyen;

        for(int i = 0; i < nbJeux ; i++)
        {
            sommePrixMoyen +=  listeJeux.get(i).getPrixBase();
        }

        if(nbJeux != 0) {
            prixMoyen = sommePrixMoyen / nbJeux;
        }else
        {
            prixMoyen = 0;
        }

        return  prixMoyen;


    }





}