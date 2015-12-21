package sessionBeans;

import entites.Commande;
import entites.Emplacement;
import entites.Garniture;
import entites.LigneCommande;
import entites.Produit;
import entites.Tablee;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateful
public class BeanCommande implements BeanCommandeLocal {

    @EJB
    private BeanMenuLocal beanMenu;

    @PersistenceContext(unitName = "montgallette-ejbPU")
    private EntityManager em;

    @Override
    public Commande validerCommande(Tablee t, List<LigneCommande> produits, String numero, Date date) {// BOUTON VALIDER COMMANDE
        Commande c = new Commande(t, produits, numero, date);
        em.persist(c);
        return c;
    }
    
    
    

    // public Commande(Tablee tablee, List<LigneCommande> produits, String numero, Date date)
    @Override
    public List<LigneCommande> listeLigne(List<Produit> produits) {
        Commande c = new Commande();
        List<LigneCommande> liste = new ArrayList();
        for (Produit p : produits) {
            liste.add(new LigneCommande(p, 0, c));
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
    
    //Creer Commande ajout ALC
    @Override
    public String creerCommande(Tablee t){
        Commande c = new Commande();
        GregorianCalendar d = new GregorianCalendar();
        String numTable = "";
        
        Collection<Emplacement> collEmp = t.getEmplacements();
        
        for(Emplacement e : collEmp){
            numTable = numTable+e.getNumero();
        }
        
       
        
        String num = String.valueOf(d.YEAR+d.MONTH+d.DAY_OF_MONTH+d.HOUR_OF_DAY+d.MINUTE+numTable);
        c.setDate(d.getTime());
        c.setNumero(num);
        c.setTablee(t);
        
        return num;
    }
    
    @Override
      public Commande creerCommandeC(Tablee t){
        Commande c = new Commande();
        GregorianCalendar d = new GregorianCalendar();
        String numTable = null;
        
        Collection<Emplacement> collE = t.getEmplacements();
        
        for(Emplacement e : collE){
            numTable = numTable+e.getNumero();
        }
        
       
        
        String num = String.valueOf(d.YEAR+d.MONTH+d.DAY_OF_MONTH+d.HOUR_OF_DAY+d.MINUTE+numTable);
        c.setDate(d.getTime());
        c.setNumero(num);
        c.setTablee(t);
        em.persist(c);
        return c;
    }
    
    //Ajout ALC
    @Override
    public String recupNumero(Commande c){
        return c.getNumero();
    }
    
    
    
    //Ajout ALC
    @Override
    public List<Commande> recupCommande(Tablee t){
        String req = "select c from Commande c where c.tablee = :t";
        Query qr = em.createQuery(req);
        qr.setParameter("t", t);
        return qr.getResultList();
    }
    
    @Override
     public Commande recupCommande(String num){
        String req = "select c from Commande c where c.numero = :num";
        Query qr = em.createQuery(req);
        qr.setParameter("num", num);
        return (Commande)qr.getSingleResult();
    }
     
    @Override
     public Collection<LigneCommande> recupListe(String num){
        String req = "select c from Commande c where c.numero = :num";
        Query qr = em.createQuery(req);
        qr.setParameter("num", num);
        Commande c = (Commande)qr.getSingleResult();

        return c.getProduits();
    }
    

    @Override
    public void jeuEssaiCommande(List<LigneCommande> liste, Tablee t) {
        Commande c = new Commande();
        GregorianCalendar d = new GregorianCalendar();

        c.setProduits(liste);
        c.setDate(d.getTime());
        c.setNumero("123456");
        c.setTablee(t);

        em.persist(c);

    }


    @Override
    public Commande ajouterLigne(Produit produit, Integer etat, Commande commande, List<String> preferences, List<Garniture> garnitures) {

        LigneCommande ligne = new LigneCommande(produit, etat, commande);
        ligne.setPreferences(preferences);
        ligne.setGarnitures(garnitures);
        Collection<LigneCommande> liste = commande.getProduits();
        liste.add(ligne);
        commande.setProduits(ligne);
        return commande;
    }
    
    @Override
     public void persist(Commande c) {
        em.persist(c);
    }

}
