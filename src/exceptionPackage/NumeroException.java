package exceptionPackage;

public class NumeroException extends Exception {

    private String numero;

    public NumeroException(String numero)
    {
        this.numero = numero;
    }

    public String getMessage()
    {
        String message;
        if(numero.isEmpty())
        {
            message = "Le numero est un champ obligatoire";
        }
        else
        {
            message = "La valeur : (" + numero + ") entrée pour le numero est invalide";
        }
        return message;
    }




}
