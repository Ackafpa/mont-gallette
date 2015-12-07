package sessionBeans;

import entites.Commande;
import entites.LigneCommande;

import entites.Produit;

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
        return new Commande();
    }

    public void ajouterLigne(Produit produit, Integer etat, Commande commande) {

        if (commande != null) {

            LigneCommande ligne = new LigneCommande(produit, etat, commande);

            Collection<LigneCommande> liste = commande.getProduits();
            liste.add(ligne);

            Collection<LigneCommande> p = commande.getProduits();
            em.persist(p);

        }
    }

    public String supprimerLigne(Commande commande, LigneCommande ligne) {
        Collection<LigneCommande> liste = commande.getProduits();
        liste.remove(ligne);
        return ligne.toString();
    }

//    
//        else {
//            commande = new Commande();
//        commande.setProduits((Collection<LigneCommande>) ligne);
//}

    

    

    public void afficherCommande() {

    }
   

public void passerCommande() {

    }

   
    public void appliquerOffre() {

    }

}
