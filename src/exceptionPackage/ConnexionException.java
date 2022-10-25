package exceptionPackage;

public class ConnexionException  extends Exception{

    public String getMessage()
    {
        return "La connexion à la base de données a échoué ";
    }
}
