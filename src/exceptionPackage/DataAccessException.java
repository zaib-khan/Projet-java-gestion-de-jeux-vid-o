package exceptionPackage;

public class DataAccessException  extends  Exception{

    private int errorCode;

    public DataAccessException(int errorCode)
    {
        setErrorCode(errorCode);
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String getMessage() {
        switch(errorCode){
            case 1152:
                return "Connexion interrompue";
            default:
                return "Erreur inconnue";
        }
    }

}
