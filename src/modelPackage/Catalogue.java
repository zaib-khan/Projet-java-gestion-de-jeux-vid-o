package modelPackage;

public class Catalogue {

    private Jeu jeu;
    private Plateforme plateforme;


    public Catalogue(Jeu jeu, Plateforme plateforme) {
        setJeu(jeu);
        setPlateforme(plateforme);
    }


    public void setJeu(Jeu jeu) {
        this.jeu = jeu;
    }

    public void setPlateforme(Plateforme plateforme) {
        this.plateforme = plateforme;
    }

    public Jeu getJeu() {
        return jeu;
    }

    public Plateforme getPlateforme() {
        return plateforme;
    }
}
