package exceptionPackage;

public class IdentifiantException extends Exception {


    private String identifiant;

    public IdentifiantException(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getMessage() {
        String message;
        if (identifiant.isEmpty()) {
            message = "L'identifiant est un champ obligatoire";
        } else {
            message = "La valeur : (" + identifiant + ") entrée pour l'identifiant est invalide";
        }
        return message;
    }

}