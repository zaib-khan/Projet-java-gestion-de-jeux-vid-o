package exceptionPackage;

public class PrenomException extends Exception {

    private String prenom;

    public PrenomException(String prenom)
    {
        this.prenom = prenom;
    }

    public String getMessage()
    {
        String message;
        if(prenom.isEmpty())
        {
            message = "Le prénom est un champ obligatoire";
        }
        else
        {
            message = "La valeur : (" + prenom + ") entrée pour le prénom est invalide";
        }
        return message;
    }
}
