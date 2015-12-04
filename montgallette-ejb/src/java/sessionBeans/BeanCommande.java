package sessionBeans;

import entites.Commande;
import entites.LigneCommande;
import java.util.Collection;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cdi404
 */
@Stateful
public class BeanCommande implements BeanCommandeLocal {

    @PersistenceContext(unitName = "montgallette-ejbPU")
    private EntityManager em;

    public Commande ajouterLigne(LigneCommande ligne, Commande commande) {

        if (commande != null) {

            Collection<LigneCommande> p = commande.getProduits();
            em.persist(p);

        } else {
            commande = new Commande();
            commande.setProduits((Collection<LigneCommande>) ligne);
            

        }
        return commande;
    }

    public void passerCommande() {

    }

    public void afficherCommande() {

    }

    public void appliquerOffre() {

    }

}
