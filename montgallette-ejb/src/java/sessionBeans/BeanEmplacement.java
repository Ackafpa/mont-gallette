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
    
    
    public void rendreIndispo(){        // true=dispo      false=occupee
        if (e.getDispo() == false){
            e.setDispo(true); 
        }else{
            //MESSAGE ERREUR "DEJA DISPO ???"
        }
    }
    
    public void rendreDispo(){        // true=dispo      false=occupee
        if (e.getDispo() == true){
            e.setDispo(false); 
        }else{
            //MESSAGE ERREUR "DEJA INDISPO ???"
        }
    }
    
    public void lierTables(){
        //Remplir arrayList Tablee ?
    }
    
    public double calculerMontant(){
        double somme = 0;
        
        return somme;
    }
            
            
}
