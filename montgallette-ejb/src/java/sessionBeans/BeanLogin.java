package sessionBeans;

import entites.Employe;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author cdi406
 */
@Stateless
public class BeanLogin implements BeanLoginLocal {

    @PersistenceContext(unitName="montgallette-ejbPU")
    private EntityManager em;
    
    @Override
    public Employe identifierEmploye(String code){
        String req = "select c from Client c where c.code = :code";
        Query qr = em.createQuery(req);
        qr.setParameter("code", code);
        Employe e = (Employe) qr.getSingleResult();
        
        return e;
    }
    
    
    
}
