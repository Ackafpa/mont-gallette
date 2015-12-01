
package sessionBeans;

import entites.Commande;
import javax.ejb.Stateful;

/**
 *
 * @author cdi404
 */
@Stateful
public class BeanCommande implements BeanCommandeLocal {

 
    public Commande passerCommande(){
    
    
Commande commande = new Commande();

return commande;
}

public Commande afficherCommande(){
    
    Commande commande = new Commande();

return commande;
}


public void appliquerOffre(){
    
    
}
    
    
}
