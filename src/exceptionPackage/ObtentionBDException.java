package exceptionPackage;

public class ObtentionBDException extends Exception {

    public String getMessage()
    {
        return "Il y a eu un problème lors de l'obtention dans la base de données";
    }
}
