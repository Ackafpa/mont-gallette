package sessionBeans;

import entites.Commande;
import entites.LigneCommande;
import entites.Produit;
import java.util.Collection;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateful
public class BeanCommande implements BeanCommandeLocal {

    @PersistenceContext(unitName = "montgallette-ejbPU")
    private EntityManager em;

    public void ajouterLigne(Produit produit, Integer etat, Commande commande) {

        LigneCommande ligne = new LigneCommande(produit, etat, commande);

        Collection<LigneCommande> liste = commande.getProduits();
        liste.add(ligne);

    }

    public String supprimerLigne(Commande commande, LigneCommande ligne) {
        Collection<LigneCommande> liste = commande.getProduits();
        liste.remove(ligne);
        return ligne.toString();
    }

    public void afficherCommande() {

    }

    public void appliquerOffre() {

    }
    
    public double montantCommande(Commande c){
        double somme = 0;
        /*
        for (LigneCommande lc : c.getProduits().getPrix()){
            somme += c.getProduits().getPrix();
        }*/
        return somme;
    }

}
