package exceptionPackage;

public class NomException extends Exception {


    private String nom;

    public NomException(String nom)
    {
        this.nom = nom;
    }

    public String getMessage()
    {
        String message;
        if(nom.isEmpty())
        {
            message = "Le nom est un champ obligatoire";
        }
        else
        {
            message = "La valeur : (" + nom + ") entrée pour le nom est invalide";
        }
        return message;
    }



}
