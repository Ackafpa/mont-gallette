package sessionBeans;

import entites.Emplacement;
import entites.Tablee;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class BeanEmplacement implements BeanEmplacementLocal {
    @PersistenceContext(unitName = "montgallette-ejbPU")
    private EntityManager em;

    public void modifierDispo(Emplacement e) {        
// true=dispo      false=occupee
        if (e.isDispo() == false) {
            e.setDispo(true);
        } else {
            e.setDispo(false);
        }
    }

    public void ajouterEmplacement(Tablee t, Emplacement e) {
        if (e.isDispo()) {
            t.getEmplacements().add(e);
            modifierDispo(e);
        } else {
            System.out.println("ERREUR : L'emplacement " + e + " n'est pas disponible!");
        }
    }

    public void supprimerEmplacement(Tablee t, Emplacement e) {
        if (t.getEmplacements().contains(e)) {
            t.getEmplacements().remove(e);
        } else {
            System.out.println("ERREUR : L'emplacement " + e + " n'est pas lié à la tablée");
        }
    }
    
    @Override
    public void creerJeu(){
        List<Emplacement> lemp = new ArrayList();
        
        for(int i =1; i<19; i++){
            String numero = ""+i;
            lemp.add(new Emplacement(true, numero));
        }
        
        for(Emplacement e: lemp){
            em.persist(e);
        }
        
    }
    
    @Override
    public Emplacement recupEmplacement(String numero){
        return (Emplacement)em.find(Emplacement.class, numero);
    }

    public void persist(Object object) {
        em.persist(object);
    }

}
