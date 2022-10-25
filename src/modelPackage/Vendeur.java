package modelPackage;

import java.util.Date;

public class Vendeur {

    private Integer numIdentifiant;
    private Etablissement etablissement;
    private String nom;
    private String prenom;
    private Date dateNaissance;



    public Vendeur(Integer numIdentifiant, Etablissement etablissement, String nom, String prenom, Date dateNaissance)
    {
       setNumIdentifiant(numIdentifiant);
       setEtablissement(etablissement);
       setNom(nom);
       setPrenom(prenom);
       setDateNaissance(dateNaissance);
    }


    public void setNumIdentifiant(Integer numIdentifiant) {
        this.numIdentifiant = numIdentifiant;
    }

    public void setEtablissement(Etablissement etablissement) {
        this.etablissement = etablissement;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Integer getNumIdentifiant() {
        return numIdentifiant;
    }

    public Etablissement getEtablissement() {
        return etablissement;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }
}
