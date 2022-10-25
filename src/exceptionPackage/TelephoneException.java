package exceptionPackage;

public class TelephoneException extends Exception {

    String telephone;

   public TelephoneException(String telephone){
      this.telephone = telephone;
   }


    public String getMessage()
    {

            return  "La valeur : (" + telephone + ") entrée pour le numero est invalide (format :ex 086476312)";


    }
}
