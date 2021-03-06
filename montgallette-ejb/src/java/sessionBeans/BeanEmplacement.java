package sessionBeans;

import entites.Emplacement;
import entites.Tablee;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class BeanEmplacement implements BeanEmplacementLocal {

    @PersistenceContext(unitName = "montgallette-ejbPU")
    private EntityManager em;

    @Override
    public void modifierDispo(HashMap<String, Emplacement> lemp, String numero) {
// true=dispo      false=occupee
        Emplacement e = lemp.get(numero);
        if (e.isDispo() == false) {
            e.setDispo(true);
            lemp.replace(numero, e);
        } else {
            e.setDispo(false);
            lemp.replace(numero, e);
        }
        em.merge(e);
    }

    @Override
    public void ajouterEmplacement(Tablee t, HashMap<String, Emplacement> lemp, String numero) {
        Emplacement e = lemp.get(numero);
        if (e.isDispo()) {

            modifierDispo(lemp, numero);
            t.getEmplacements().add(e);
        } else {
            System.out.println("ERREUR : L'emplacement " + e + " n'est pas disponible!");
        }
    }

    @Override
    public void supprimerEmplacement(Tablee t, HashMap<String, Emplacement> lemp, String numero) {
        Emplacement e = lemp.get(numero);
        if (t.getEmplacements().contains(e)) {
            t.getEmplacements().remove(e);
        } else {
            System.out.println("ERREUR : L'emplacement " + e + " n'est pas lié à la tablée");
        }
    }

    @Override
    public HashMap<String, Emplacement> creerJeu() {
        HashMap<String, Emplacement> lemp = new HashMap();
        String numero;
        for (int i = 1; i < 19; i++) {
            if (i < 10) {
                numero = "0" + i;
            } else {
                numero = "" + i;
            }
            Emplacement e = new Emplacement(true, numero);
            em.persist(e);
            lemp.put(numero, e);
        }

        return lemp;
    }

    @Override
    public Collection<Emplacement> collEmplacement(String numero) {
        Collection<Emplacement> coll = new ArrayList();

        Emplacement e = recupEmplacement(numero);
        coll.add(e);

        return coll;
    }

    @Override
    public Emplacement recupEmplacement(String numero) {
        return (Emplacement) em.find(Emplacement.class, numero);
    }

    public void persist(Object object) {
        em.persist(object);
    }

    @Override
    public List<Emplacement> getListeEmplacement() {
        String req = "select e from Emplacement e";

        Query qr = em.createQuery(req);
        List<Emplacement> listeEmp = (List<Emplacement>) qr.getResultList();

        Collections.sort(listeEmp);

        return listeEmp;
    }

    @Override
    public List<Emplacement> sort(HashMap<String, Emplacement> liste) {
        Collection<Emplacement> emp = liste.values();
        List<Emplacement> listEmp = new ArrayList();
        listEmp.addAll(emp);
        Collections.sort(listEmp);
        return listEmp;
    }

}
