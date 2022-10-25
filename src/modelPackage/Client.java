package modelPackage;

import exceptionPackage.*;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Client {

    private String identifiant;
    private Integer matricule;
    private String nom;
    private String prenom;
    private String codePostal;
    private String ville;
    private String rue;
    private String numero;
    private GregorianCalendar dateNaissance;
    private String telephone;
    private String email;
    private Boolean carteFidelite;
    private Double tailleLunette;
    private Double tailleCeinture;
    private String tailleVetement;

    public Client(){

    }

    public Client(String identifiant, int matricule, String nom, String prenom, String codePostal, String ville, String rue, String numero, GregorianCalendar dateNaissance, String telephone, String email, Boolean carteFidelite, Double tailleLunette, Double tailleCeinture, String tailleVetement)
            throws NomException,PrenomException, CodePostalException,VilleException,RueException,NumeroException,DateNaissanceException,IdentifiantException,EmailException
    {
        setIdentifiant(identifiant);
        setMatricule(matricule);
        setNom(nom);
        setPrenom(prenom);
        setCodePostal(codePostal);
        setVille(ville);
        setRue(rue);
        setNumero(numero);
        setDateNaissance(dateNaissance);
        setTelephone(telephone);
        setEmail(email);
        setCarteFidelite(carteFidelite);
        setTailleLunette(tailleLunette);
        setTailleCeinture(tailleCeinture);
        setTailleVetement(tailleVetement);
    }


    public Client(String identifiant, int matriculeEtablissement, String nom, String prenom, String codePostal, String ville, String rue, String numero, GregorianCalendar dateNaissance,String telephone,String email, Boolean carteFidelite)
            throws NomException,PrenomException, CodePostalException,VilleException,RueException,NumeroException,DateNaissanceException,IdentifiantException,EmailException
    {
        setIdentifiant(identifiant);
        setMatriculeEtablissement(matriculeEtablissement);
        setNom(nom);
        setPrenom(prenom);
        setCodePostal(codePostal);
        setVille(ville);
        setRue(rue);
        setNumero(numero);
        setDateNaissance(dateNaissance);
        setTelephone(telephone);
        setEmail(email);
        setCarteFidelite(carteFidelite);
    }

    public Client(String identifiant, int matriculeEtablissement) {
        this.identifiant = identifiant;
        this.matricule = matriculeEtablissement;
    }



    public void setMatricule(int matricule)
    {
        this.matricule = matricule;
    }

    public void setIdentifiant(String identifiant)throws IdentifiantException {

        if(!identifiant.isEmpty() && identifiant.matches("[A-Za-z0-9]*") ) {
            this.identifiant = identifiant;
        }
        else
        {
            throw new IdentifiantException(identifiant);
        }
    }


    public void setMatriculeEtablissement(int matriculeEtablissement) {
        this.matricule = matriculeEtablissement;
    }

    public void setNom(String nom)throws  NomException {

        if(nom.matches("[A-Za-z]*") && !nom.isEmpty())
        {
            this.nom = nom;
        }
        else
        {
            throw new NomException(nom);
        }


    }

    public void setPrenom(String prenom)throws PrenomException {

        if(prenom.matches("[A-Za-z]*") && !prenom.isEmpty())
        {
            this.prenom = prenom;
        }
        else
        {
            throw new PrenomException(prenom);
        }
    }

    public void setCodePostal(String codePostal)throws CodePostalException {

        if(!codePostal.isEmpty() && codePostal.matches("[0123456789]*"))
        {
            this.codePostal = codePostal;
        }
        else
        {
            throw new CodePostalException(codePostal);
        }
    }


    public void setVille(String ville)throws  VilleException {

        if(!ville.isEmpty())
        {
            this.ville = ville;
        }
        else
        {
            throw new  VilleException(ville);
        }
    }

    public void setRue(String rue)throws RueException {
        if(!rue.isEmpty())
        {
           this.rue = rue;
       }
        else
        {
            throw new RueException();
        }
    }

    public void setNumero(String numero)throws NumeroException {

        if(!numero.isEmpty() && numero.matches("[0123456789]*") && Integer.parseInt(numero)> 0)
        {
            this.numero = numero;
        }
        else
        {
            throw new NumeroException(numero);
        }
    }

    public void setDateNaissance(GregorianCalendar dateNaissance)throws DateNaissanceException {

        if(dateNaissance.get(Calendar.YEAR) <= LocalDate.now().getYear())
        {
            this.dateNaissance = dateNaissance;
        }
        else
        {
            throw new DateNaissanceException(dateNaissance);
        }
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }




    public void setEmail(String email) throws EmailException {

        if((email == null)  || email.matches("^(.+)@(.+)$")) {
            this.email = email;
        }
        else {
            throw new EmailException();
        }



        }



    public void setCarteFidelite(Boolean carteFidelite) {
        this.carteFidelite = carteFidelite;
    }

    public void setTailleLunette(Double tailleLunette) {
        this.tailleLunette = tailleLunette;
    }

    public void setTailleCeinture(Double tailleCeinture) {
        this.tailleCeinture = tailleCeinture;
    }

    public void setTailleVetement(String tailleVetement) {
        this.tailleVetement = tailleVetement;
    }


    public String getIdentifiant() {
        return identifiant;
    }

    public int getMatriculeEtablissement() {
        return matricule;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public String getVille() {
        return ville;
    }

    public String getRue() {
        return rue;
    }

    public String getNumero() {
        return numero;
    }

    public GregorianCalendar getDateNaissance() {
        return dateNaissance;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    public Boolean getCarteFidelite() {
        return carteFidelite;
    }

    public Double getTailleLunette() {
        return tailleLunette;
    }

    public Double getTailleCeinture() {
        return tailleCeinture;
    }

    public String getTailleVetement() {
        return tailleVetement;
    }

    public Integer getMatricule() {
        return matricule;
    }
    public Date affichageDateNaissance()
    {
        //DateFormat format = DateFormat.getDateInstance(DateFormat.SHORT);
      //  String bDate = format.format(dateNaissance.getTime()) ;
        Date dateN = dateNaissance.getTime();
       return dateN;
    }
}
