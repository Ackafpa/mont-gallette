package sessionBeans;

import entites.Emplacement;
import javax.ejb.Stateful;

/**
 *
 * @author CDI417
 */
@Stateful
public class BeanEmplacement implements BeanEmplacementLocal {
    Emplacement e = new Emplacement();
    
    
    public int modifierDispo(int i){        //
        if (e.getDispo() == 0 && i == 1){
            e.setDispo(i); 
        }
        
        
        
//        return i;
    }
    
    public void lierTables(){
        
    }
    
    public double calculerMontant(){
        double somme = 0;
        
        return somme;
    }
            
            
}
