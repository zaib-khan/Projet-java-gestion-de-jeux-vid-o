package modelPackage;

import java.util.GregorianCalendar;

public class ModelRechercheFacture {

    private GregorianCalendar dateFacture;
    private Integer numeroFacture;
    private String nomVendeur;
    private String prenomVendeur;
    private String nomEtablissement;


    public ModelRechercheFacture(GregorianCalendar dateFacture, Integer numeroFacture, String nomVendeur, String prenomVendeur, String nomEtablissement) {
        this.dateFacture = dateFacture;
        this.numeroFacture = numeroFacture;
        this.nomVendeur = nomVendeur;
        this.prenomVendeur = prenomVendeur;
        this.nomEtablissement = nomEtablissement;
    }

    public GregorianCalendar getDateFacture() {
        return dateFacture;
    }

    public Integer getNumeroFacture() {
        return numeroFacture;
    }

    public String getNomVendeur() {
        return nomVendeur;
    }

    public String getPrenomVendeur() {
        return prenomVendeur;
    }

    public String getNomEtablissement() {
        return nomEtablissement;
    }

    public void setDateFacture(GregorianCalendar dateFacture) {
        this.dateFacture = dateFacture;
    }

    public void setNumeroFacture(Integer numeroFacture) {
        this.numeroFacture = numeroFacture;
    }

    public void setNomVendeur(String nomVendeur) {
        this.nomVendeur = nomVendeur;
    }

    public void setPrenomVendeur(String prenomVendeur) {
        this.prenomVendeur = prenomVendeur;
    }

    public void setNomEtablissement(String nomEtablissement) {
        this.nomEtablissement = nomEtablissement;
    }
}
