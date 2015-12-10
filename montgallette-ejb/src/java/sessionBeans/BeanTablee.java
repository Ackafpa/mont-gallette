package sessionBeans;

import entites.Commande;
import entites.Tablee;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
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
        tables.add(new Tablee(4));
        tables.add(new Tablee(2));
        tables.add(new Tablee(6));
        tables.add(new Tablee(8));
        tables.add(new Tablee(98));
        for(Tablee t : tables){
        em.persist(t);
        }
    }
    
    @Override
    public Tablee selectTable(long l){
        String req = "select t from Tablee t where t.id = :id";
        Query qr = em.createQuery(req);
        qr.setParameter("num", l);
        Tablee t = (Tablee) qr.getSingleResult();
        return t;
    }

    public double addition(Tablee t) {
        double somme = 0;

        for (Commande c : t.getCommandes()) {
            //A FINALISER / VERIFIER AVEC CLASSE COMMANDE
            // somme += t.getCommandes().getMontantCommande();
        }
        return somme;
    }

    public void persist(Object object) {
        em.persist(object);
    }

}
