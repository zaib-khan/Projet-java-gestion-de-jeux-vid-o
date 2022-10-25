package modelPackage;

public class Plateforme {

    private String libelle;

    public Plateforme(String libelle) {
        setLibelle(libelle);
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }
}
