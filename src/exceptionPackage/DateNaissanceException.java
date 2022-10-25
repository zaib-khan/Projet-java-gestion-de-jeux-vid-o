package exceptionPackage;

import java.util.GregorianCalendar;

public class DateNaissanceException extends Exception {

        private GregorianCalendar dateNaissance;

        public DateNaissanceException(GregorianCalendar dateNaissance)
        {
            this.dateNaissance = dateNaissance;
        }

        public String getMessage()
        {
            return "La date de naissance est invalide ";
        }

}
