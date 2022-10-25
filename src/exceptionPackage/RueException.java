package exceptionPackage;

public class RueException extends Exception {

    public String getMessage()
    {
        String message;

        message = "La rue est un champ obligatoire";

        return message;


    }

}
