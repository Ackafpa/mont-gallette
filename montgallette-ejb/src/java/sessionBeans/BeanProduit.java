package sessionBeans;

import entites.Produit;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class BeanProduit implements BeanProduitLocal {

    @PersistenceContext(unitName = "montgallette-ejbPU")
    private EntityManager em;

    public ArrayList<Produit> consulterMenu() {

        String req = "select ";
        ArrayList<Produit> produits = new ArrayList();

        return produits;
    }

    //méthode de CHRIS à accepter !
    @Override
    public Produit trouverProduit(String id) {
//
//        String req = "select p from Produit p where p.id = :id ";
//        Query qr = em.createQuery(req);
//        qr.setParameter("id", id);
//       
        Long idProduit = Long.parseLong(id);
        return em.find(Produit.class,idProduit);
    }
    //Fin Méthode Chris

}
