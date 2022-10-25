package modelPackage;

import java.util.GregorianCalendar;

public class Facture {

    private Integer numero;
    private GregorianCalendar date;
    private Integer vendeur;
    private String client;

    private String etablissement;

    public Facture(Integer numero, GregorianCalendar date, Integer vendeur, String client) {
        setNumero(numero);
        setDate(date);
        setVendeur(vendeur);
        setClient(client);
    }


    public String getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(String etablissement) {
        this.etablissement = etablissement;
    }

    public Facture(Integer numero)
    {
        setNumero(numero);
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    public void setVendeur(Integer vendeur) {
        this.vendeur = vendeur;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Integer getNumero() {
        return numero;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public Integer getVendeur() {
        return vendeur;
    }

    public String getClient() {
        return client;
    }
}