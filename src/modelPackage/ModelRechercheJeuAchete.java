package modelPackage;

import java.util.GregorianCalendar;

public class ModelRechercheJeuAchete {

    private String titre;
    private String edition;
    private String theme;
    private Integer limiteAge;
    private Integer anneeSortie;
    private Integer numRayon;
    private Integer numEtagere;
    private GregorianCalendar dateFacture;


    public ModelRechercheJeuAchete(String titre, String edition, String theme, Integer limiteAge, Integer anneeSortie, Integer numRayon, Integer numEtagere, GregorianCalendar dateFacture) {
        this.titre = titre;
        this.edition = edition;
        this.theme = theme;
        this.limiteAge = limiteAge;
        this.anneeSortie = anneeSortie;
        this.numRayon = numRayon;
        this.numEtagere = numEtagere;
        this.dateFacture = dateFacture;
    }

    public String getTitre() {
        return titre;
    }

    public String getEdition() {
        return edition;
    }

    public String getTheme() {
        return theme;
    }

    public Integer getLimiteAge() {
        return limiteAge;
    }

    public Integer getAnneeSortie() {
        return anneeSortie;
    }

    public Integer getNumRayon() {
        return numRayon;
    }

    public Integer getNumEtagere() {
        return numEtagere;
    }

    public GregorianCalendar getDateFacture() {
        return dateFacture;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public void setLimiteAge(Integer limiteAge) {
        this.limiteAge = limiteAge;
    }

    public void setAnneeSortie(Integer anneeSortie) {
        this.anneeSortie = anneeSortie;
    }

    public void setNumRayon(Integer numRayon) {
        this.numRayon = numRayon;
    }

    public void setNumEtagere(Integer numEtagere) {
        this.numEtagere = numEtagere;
    }

    public void setDateFacture(GregorianCalendar dateFacture) {
        this.dateFacture = dateFacture;
    }
}
