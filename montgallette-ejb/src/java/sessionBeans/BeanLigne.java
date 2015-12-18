package sessionBeans;

import entites.Commande;
import entites.LigneCommande;
import entites.Produit;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author cdi404
 */
@Stateful
public class BeanLigne implements BeanLigneLocal {

    @PersistenceContext(unitName = "montgallette-ejbPU")
    private EntityManager em;

    @Override
    public LigneCommande creerLigne(Produit p, Commande c) {
        LigneCommande lc = new LigneCommande(p, 0, c);
        return lc;
    }

    @Override
    public LigneCommande chercherLigne(Integer id) {
        System.out.println("CHERCHER LIGNE OOOOOOOOOOOOOOOOOOOOOOKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK");
        String req = "select l from LigneCommande l where id = :id";
        Query qr = em.createQuery(req);
        qr.setParameter("id", id);

        try {
            LigneCommande l = (LigneCommande) qr.getSingleResult();
            return l;
        } catch (NoResultException ex) {
            System.out.println("erroorrrrrrrrrrrrrrrrr==================================='((((((((((((((((((((((((((((((((((((((((((((((((((((((");
        }
        return null;

    }
    //Ajout ALC : Tri des produits pour la cuisine

    @Override
    public List<LigneCommande> triCuisine(List<LigneCommande> liste, List<LigneCommande> superListe) {
        List<LigneCommande> listeCuisine = new ArrayList();
        for (LigneCommande l : liste) {
            if (l.getProduit().isPreparation()) {
                listeCuisine.add(l);
            }
        }
        superListe.addAll(listeCuisine);
        return superListe;
    }

    @Override
    public LigneCommande sortirLigne(LigneCommande lc, String li) {
        while (!li.equals(String.valueOf(lc.getId()))) {
            if (li.equals(String.valueOf(lc.getId()))) {
                System.out.println("OUI" + li);
            } else {
                System.out.println(lc.getId());
                System.out.println("NON");
            }
        }
        return lc;
    }

    public void changerEtatValider(LigneCommande lc) {
        
        switch (lc.getEtat()) {
            case (0): lc.setEtat(1);
                break;
            case (1): lc.setEtat(2);
                break;
            case (2): lc.setEtat(3);
                break;
            default: //DANS LES AUTRES CAS ON CHANGE PAS L'ETAT DE LA LIGNE DE COMMANDE
                break;
        }
    }
        // 0-->Commandé
        // 1-->En préparation
        // 2-->Prêt
        // 3-->Servi
    public void changerEtatAnnuler(LigneCommande lc) {
        switch (lc.getEtat()) {
            case (3): lc.setEtat(2);
                break;
            case (2): lc.setEtat(1);
                break;
            case (1): lc.setEtat(0);
                break;
            default:    //DANS LES AUTRES CAS ON CHANGE PAS L'ETAT DE LA LIGNE DE COMMANDE
                break;
        }
    }
}
