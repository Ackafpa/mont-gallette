package sessionBeans;

import entites.Commande;
import entites.Garniture;
import entites.LigneCommande;
import entites.Produit;
import java.util.Collection;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateful
public class BeanCommande implements BeanCommandeLocal {

    @PersistenceContext(unitName = "montgallette-ejbPU")
    private EntityManager em;

    public Commande ajouterLigne(Produit produit, Integer etat, Commande commande, List<String> preferences, List<Garniture> garnitures) {

        LigneCommande ligne = new LigneCommande(produit, etat, commande);
        ligne.setPreferences(preferences);
        ligne.setGarnitures(garnitures);
        Collection<LigneCommande> liste = commande.getProduits();
        liste.add(ligne);
        commande.setProduits(ligne);
        return commande;
    }
    
//     public Commande ajouterLigne(Produit produit, Integer etat, Commande commande, String preferencesS, String garnituresS) {
//
//        LigneCommande ligne = new LigneCommande(produit, etat, commande);
//        //String []preferences = preferencesS.split(" ");
//        ligne.setPreferences(preferences);
//        ligne.setGarnitures(garnitures);
//        Collection<LigneCommande> liste = commande.getProduits();
//        liste.add(ligne);
//        commande.setProduits(ligne);
//        return commande;
//    }

    public Commande supprimerLigne(Commande commande, LigneCommande ligne) {
        Collection<LigneCommande> liste = commande.getProduits();
        liste.remove(ligne);
        commande.setProduits(liste);
        return commande;
    }


    public void appliquerOffre() {
// C'est quoi les offres ? 
    }

    public double calculerMontant(Commande commande) {
        double somme = 0;
        Double d = null;
        for (LigneCommande lc : commande.getProduits()) {
            d = lc.getProduit().getPrixHT();
            somme += d;
        }

        return somme;
    }
}
