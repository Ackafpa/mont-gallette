package sessionBeans;

import entites.Employe;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import outils.CustomException;

/**
 *
 * @author cdi406
 */
@Stateless
public class BeanLogin implements BeanLoginLocal {

    @PersistenceContext(unitName="montgallette-ejbPU")
    private EntityManager em;
    
    @Override
    public Employe identifierEmploye(String code) throws CustomException{
        HashMap err = new HashMap();
        String req = "select e from Employe e where e.code = :code";
        Query qr = em.createQuery(req);
        qr.setParameter("code", code);
        Employe e = null;
        try{
        e = (Employe) qr.getSingleResult();
        }catch(NoResultException ex){
            err.put("errCode", "Le code entré n'est pas reconnu");
        }
        
        
        if(!err.isEmpty()){
            throw new CustomException(err, CustomException.err_Id);
        }
        
        return e;
        
      
    }
    
    @Override
    public Employe deconnexion(Employe e){
        if(e != null){
            e = null;
        }
        return e;
    }
    
    @Override
    public void creerJeuTest(){
        List<Employe> emp = new ArrayList();
        
        emp.add(new Employe("Harrington", "Honor", "adresse011","12354" , "Harrington Steading", "1234"));
        emp.add(new Employe("Alexander", "Hamish", "adresse087","1654" , "White Haven", "5698"));
        emp.add(new Employe("Alexander", "Emily", "adresse087","1654" , "White Haven", "5698"));
       
        for(Employe e : emp){
            em.persist(e);
        }
    }
    
}
