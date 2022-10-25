package modelPackage;

public class Exemplaire {

    private Integer numero;
    private Jeu jeu;
    private Integer numRayon;
    private Integer numEtagere;
    private String edition;
    private Facture facture;


    public Exemplaire(Integer numero, Jeu jeu, Integer numRayon, Integer numEtagere, String edition, Facture facture)
    {
       setNumero(numero);
       setJeu(jeu);
       setNumRayon(numRayon);
       setNumEtagere(numEtagere);
       setEdition(edition);
       setFacture(facture);

    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public void setJeu(Jeu jeu) {
        this.jeu = jeu;
    }


    public void setNumRayon(Integer numRayon) {
        this.numRayon = numRayon;
    }

    public void setNumEtagere(Integer numEtagere) {
        this.numEtagere = numEtagere;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    public Integer getNumero() {
        return numero;
    }

    public Jeu getJeu() {
        return jeu;
    }

    public Integer getNumRayon() {
        return numRayon;
    }

    public Integer getNumEtagere() {
        return numEtagere;
    }

    public String getEdition() {
        return edition;
    }

    public Facture getFacture() {
        return facture;
    }
}
