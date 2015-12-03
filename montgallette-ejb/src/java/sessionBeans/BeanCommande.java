package sessionBeans;

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

    public void passerCommande() {

    }

    public void afficherCommande() {

    }

    public void appliquerOffre() {

    }

}
