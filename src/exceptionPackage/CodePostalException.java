package exceptionPackage;

public class CodePostalException extends Exception   {

    private String codePostal;

    public CodePostalException(String codePostal)
    {
        this.codePostal = codePostal;
    }

    public String getMessage()
    {
        String message;
        if(codePostal.isEmpty())
        {
            message = "Le code postal est un champ obligatoire";
        }
        else
        {
          message = "La valeur : (" + codePostal + ") entrée pour le code postal est invalide. Le code postal est composée uniquement de chiffres en Belgique";
        }
        return message;
    }



}
