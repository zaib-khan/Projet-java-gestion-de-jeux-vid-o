package modelPackage;

public class Jeu {

    private Integer code;
    private String titre;
    private String genre;
    private String theme;
    private Double prixBase;
    private Integer limiteAge;
    private Integer anneeSortie;
    private Integer jeuBaseDe;
    private Integer jeuSuiteDe;

    public Jeu(Integer code, String titre, String genre, String theme, Double prixBase, Integer limiteAge, Integer anneeSortie, Integer jeuBaseDe, Integer jeuSuiteDe)
    {
        setCode(code);
        setTitre(titre);
        setGenre(genre);
        setTheme(theme);
        setPrixBase(prixBase);
        setLimiteAge(limiteAge);
        setAnneeSortie(anneeSortie);
        setJeuBaseDe(jeuBaseDe);
        setJeuSuiteDe(jeuSuiteDe);
    }


    public void setCode(Integer code) {
        this.code = code;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public void setPrixBase(Double prixBase) {
        this.prixBase = prixBase;
    }

    public void setLimiteAge(java.lang.Integer limiteAge) {
        this.limiteAge = limiteAge;
    }

    public void setAnneeSortie(java.lang.Integer anneeSortie) {
        this.anneeSortie = anneeSortie;
    }

    public void setJeuBaseDe(Integer jeuBaseDe) {
        this.jeuBaseDe = jeuBaseDe;
    }

    public void setJeuSuiteDe(Integer jeuSuiteDe) {
        this.jeuSuiteDe = jeuSuiteDe;
    }


    public java.lang.Integer getCode() {
        return code;
    }

    public String getTitre() {
        return titre;
    }

    public String getGenre() {
        return genre;
    }

    public String getTheme() {
        return theme;
    }

    public Double getPrixBase() {
        return prixBase;
    }

    public java.lang.Integer getLimiteAge() {
        return limiteAge;
    }

    public java.lang.Integer getAnneeSortie() {
        return anneeSortie;
    }

    public Integer getJeuBaseDe() {
        return jeuBaseDe;
    }

    public Integer getJeuSuiteDe() {
        return jeuSuiteDe;
    }
}
