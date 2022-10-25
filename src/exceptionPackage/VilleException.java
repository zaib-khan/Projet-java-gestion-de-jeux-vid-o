package exceptionPackage;

public class VilleException extends Exception {


    private String ville;

    public VilleException(String ville)
    {
        this.ville = ville;
    }

    public String getMessage()
    {
        String message;
        if(ville.isEmpty())
        {
            message = "La ville est un champ obligatoire";
        }
        else
        {
            message = "La valeur : (" + ville + ") entrée pour la ville est invalide";
        }
        return message;
    }




}
