package sessionBeans;

import javax.ejb.Stateful;

/**
 *
 * @author CDI417
 */
@Stateful
public class BeanEmplacement implements BeanEmplacementLocal {

    public int modifierDispo(){
        return 1;
    }
    
    public void lierTables(){
        
    }
    
    public double calculerMontant(){
        double somme = 0;
        
        return somme;
    }
            
            
}
