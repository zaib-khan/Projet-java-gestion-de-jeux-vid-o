package modelPackage;

public class Goodie {

    private Integer code;
    private String libelle;
    private Double prixbase;
    private String type;
    private Integer facture;


    public Goodie(Integer code, String libelle, Double prixbase, String type, Integer facture)
    {
        setCode(code);
        setLibelle(libelle);
        setPrixbase(prixbase);
        setType(type);
        setFacture(facture);
    }

    public void setCode(Integer code) {
        this.code = code;
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

    public void setFacture(Integer facture) {
        this.facture = facture;
    }

    public Integer getCode() {
        return code;
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

    public Integer getFacture() {
        return facture;
    }
}
