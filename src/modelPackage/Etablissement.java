package modelPackage;

public class Etablissement {

    private Integer matricule;
    private String nom;
    private String adresse;
    private String telephone;
    private String email;


    public Etablissement(){

    }
    public Etablissement(Integer matricule,String nom,String adresse,String telephone,String email)
    {
        setMatricule(matricule);
        setNom(nom);
        setAdresse(adresse);
        setTelephone(telephone);
        setEmail(email);
    }


    public void setMatricule(Integer matricule) {
        this.matricule = matricule;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getMatricule() {
        return matricule;
    }

    public String getNom() {
        return nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }
}
