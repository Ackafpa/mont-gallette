package sessionBeans;

import entites.Commande;
import entites.Emplacement;
import entites.Tablee;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateful
public class BeanTablee implements BeanTableeLocal {
    @PersistenceContext(unitName = "montgallette-ejbPU")
    private EntityManager em;

    public void appelerGarcon() {
        //Envoyer alerte au serveur
    }

    @Override
    public void modifCouverts(Tablee t, int n) {
        t.setCouverts(n);
    }
    
    @Override
    public void jeuTables(){
        Collection<Tablee> tables = new ArrayList();
        tables.add(new Tablee());
        tables.add(new Tablee());
        tables.add(new Tablee());
        tables.add(new Tablee());
        tables.add(new Tablee());
        for(Tablee t : tables){
        em.persist(t);
        }
    }
    
    @Override
    public Tablee selectTable(Long l){
        String req = "select t from Tablee t where t.id = :id";
        Query qr = em.createQuery(req);
        qr.setParameter("id", l);
        Tablee t = (Tablee) qr.getSingleResult();
        return t;
    }

    @Override
    public double addition(Tablee t) {
        double somme = 0;

        for (Commande c : t.getCommandes()) {
            //A FINALISER / VERIFIER AVEC CLASSE COMMANDE
            // somme += t.getCommandes().getMontantCommande();
        }
        return somme;
    }
    
    @Override
    public Tablee recupTablee(Emplacement e){
        String req = "select t from Tablee t where t.emplacements = :coll";
        Query qr = em.createQuery(req);
        qr.setParameter("coll", e);
        try{
        Tablee t = (Tablee)qr.getSingleResult();
        return t;
        }catch(NoResultException ex){
            Tablee t = null;
            return t;
        }
        
    }
    
    @Override
    public Tablee creerTablee(Integer couverts, Emplacement e){
        Collection<Emplacement> coll = new ArrayList();
        e.setDispo(false);

        coll.add(e);
        Tablee t = new Tablee(couverts, coll);
        
        em.persist(t);

        return t;
    }

    @Override
    public void persist(Tablee t) {
        em.persist(t);
    }

}
