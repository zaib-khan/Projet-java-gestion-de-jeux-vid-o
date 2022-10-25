package modelPackage;

import java.util.GregorianCalendar;

public class ModelRechercheGoodie {

    private String libelle;
    private Double prixbase;
    private String type;
    private GregorianCalendar dateFacture;
    private String nom;
    private String prenom;

    public ModelRechercheGoodie(String libelle, Double prixbase, String type, GregorianCalendar dateFacture, String nom, String prenom) {
        this.libelle = libelle;
        this.prixbase = prixbase;
        this.type = type;
        this.dateFacture = dateFacture;
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getLibelle() {
        return libelle;
    }

    public Double getPrixbase() {
        return prixbase;
    }

    public String getType() {
        return type;
    }

    public GregorianCalendar getDateFacture() {
        return dateFacture;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setPrixbase(Double prixbase) {
        this.prixbase = prixbase;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDateFacture(GregorianCalendar dateFacture) {
        this.dateFacture = dateFacture;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
