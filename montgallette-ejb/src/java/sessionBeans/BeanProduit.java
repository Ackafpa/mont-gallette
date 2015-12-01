
package sessionBeans;

import entites.Produit;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class BeanProduit implements BeanProduitLocal {

    @PersistenceContext(unitName="montgallette-ejbPU")
    private EntityManager em;
    
    
    
    public ArrayList<Produit> consulterMenu(){
        
        //String req = "select ";
        ArrayList<Produit> produits = new ArrayList();
        
        
        
        return produits;
    }
    
    
}
