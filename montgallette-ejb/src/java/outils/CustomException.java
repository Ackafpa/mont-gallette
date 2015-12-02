package outils;

import java.util.HashMap;

/**
 *
 * @author cdi406
 */
public class CustomException extends Exception{
    public static final String err_Id;
    
    static{
        err_Id = "Code non reconnu";
    }
    
    private HashMap erreurs;

    public CustomException() {
        erreurs = new HashMap();
    }

    public CustomException(HashMap erreurs, String message) {
        super(message);
        this.erreurs = erreurs;
    }

    public HashMap getErreurs() {
        return erreurs;
    }

    public void setErreurs(HashMap erreurs) {
        this.erreurs = erreurs;
    }
    
    
    
    
}
