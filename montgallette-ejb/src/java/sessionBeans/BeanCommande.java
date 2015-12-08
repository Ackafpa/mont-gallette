package sessionBeans;

import entites.Commande;
import entites.Garniture;
import entites.LigneCommande;
import entites.Produit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateful
public class BeanCommande implements BeanCommandeLocal {

    @PersistenceContext(unitName = "montgallette-ejbPU")
    private EntityManager em;

    public Commande ajouterLigne(Produit produit, Integer etat, Commande commande,List <String> preferences, List<Garniture>garnitures) {

        LigneCommande ligne = new LigneCommande(produit, etat, commande);
        ligne.add(preferences);
        ligne.add()
        Collection<LigneCommande> liste = commande.getProduits();
        liste.add(ligne);
        commande.setProduits(ligne);
        return commande;
    }

    public String supprimerLigne(Commande commande, LigneCommande ligne) {
        Collection<LigneCommande> liste = commande.getProduits();
        liste.remove(ligne);
        return ligne.toString();// C'est pour le message de suppression éventuellement
    }

    public List afficherCommande(Commande commande) {
        List<LigneCommande> liste = new ArrayList();
        for (LigneCommande l : commande.getProduits()) {
            liste.add(l);
            return liste;

        }
        return liste;

    }

    public void appliquerOffre() {
// C'est quoi les offres ? 
    }

    public double calculerMontant(Commande commande) {
        double somme = 0;

//   Ligne d'Anthony avec un get inexistant     for (LigneCommande lc : commande.getProduits().getPrix()){
//            somme += commande.getProduits().getPrix();
        return somme;
    }

}
