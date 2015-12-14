package sessionBeans;

import entites.Commande;
import entites.Garniture;
import entites.LigneCommande;
import entites.Produit;
import entites.Tablee;
import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateful
public class BeanCommande implements BeanCommandeLocal {
    @EJB
    private BeanMenuLocal beanMenu;

    @PersistenceContext(unitName = "montgallette-ejbPU")
    private EntityManager em;

    
    
    @Override
    public List<LigneCommande> listeLigne(List<Produit> produits){
       Commande c = new Commande();
        List <LigneCommande> liste = new ArrayList();
        for(Produit p : produits){
        liste.add (new LigneCommande(p, 0, c));
        }
        return liste;
    }
    
    @Override
    public void triCuisine(List<LigneCommande> liste, List<LigneCommande>superListe){
        
        for(LigneCommande l : liste){
            if(l.getProduit().isPreparation()){
               superListe.add(l);
            }
        }
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
    

    
    @Override
    public void jeuEssaiCommande(List<LigneCommande> liste, Tablee t){
        Commande c = new Commande();
        GregorianCalendar d = new GregorianCalendar();
        
        
       
        c.setProduits(liste);
        c.setDate(d.getTime());
        c.setNumero("123456");
        c.setTablee(t);
        
        
        em.persist(c);
       
    }
    
    
    
    
    
    
    
    
    
    
    public Commande ajouterLigne(Produit produit, Integer etat, Commande commande, List<String> preferences, List<Garniture> garnitures) {

        LigneCommande ligne = new LigneCommande(produit, etat, commande);
        ligne.setPreferences(preferences);
        ligne.setGarnitures(garnitures);
        Collection<LigneCommande> liste = commande.getProduits();
        liste.add(ligne);
        commande.setProduits(ligne);
        return commande;
    }
    
}
