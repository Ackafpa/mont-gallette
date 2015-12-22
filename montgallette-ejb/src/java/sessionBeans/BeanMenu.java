package sessionBeans;

import entites.Categorie;
import entites.Produit;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class BeanMenu implements BeanMenuLocal {

    @PersistenceContext(unitName = "montgallette-ejbPU")
    private EntityManager em;
    private boolean jeuxCree;
    
    @Override
    public void creerJeuxDonnees(){
        
        String descrCourte = "Description courte";
        String descrComplete = "Description complete :Suspendisse potenti. In hac habitasse platea dictumst. Donec finibus laoreet finibus. Phasellus ut ante tincidunt, venenatis ante eget, volutpat risus."; // Sed viverra at justo vitae pulvinar. Curabitur facilisis lectus ac justo mollis luctus. Sed suscipit sapien et massa semper, nec interdum libero condimentum. Curabitur mi mauris, convallis feugiat enim posuere, accumsan rutrum quam. Aenean gravida libero lorem, nec sagittis justo molestie ut.";
        
        List<Produit> lp = new ArrayList();
        List<Categorie> lc = new ArrayList();
        
        lc.add(new Categorie("Entree"));
        lc.add(new Categorie("Plat"));
        lc.add(new Categorie("Dessert"));
        lc.add(new Categorie("Boisson"));
        
        lc.stream().forEach((c) -> {em.persist(c);});

        lp.add(new Produit("Soupe au potiron au comté", true, true, 5.9, descrCourte, descrComplete, lc.get(0),"images/menu/soupepoitiron.jpg"));
        lp.add(new Produit("Grande assiette à partager", true, true, 12.9, descrCourte, descrComplete, lc.get(0),"images/menu/assietteparteger.jpg"));
        lp.add(new Produit("Terrine de champagne", true, true, 4.6, descrCourte, descrComplete, lc.get(0),"images/menu/terrinecampagne.jpg"));
        lp.add(new Produit("Faisselle de fromage blanc", true, true, 5.8, descrCourte, descrComplete, lc.get(0),"images/menu/faissellefblanc.jpg"));
        
        lp.add(new Produit("Steak dans la hampe", true, true, 11.30, descrCourte, descrComplete, lc.get(1),"images/menu/steakhampe.jpg"));
        lp.add(new Produit("Tartare de boeuf", true, true, 15.5, descrCourte, descrComplete, lc.get(1),"images/menu/tartareboeuf.jpg"));
        lp.add(new Produit("Pavé de rumsteak", true, true, 15.95, descrCourte, descrComplete, lc.get(1),"images/menu/paverumsteak.jpg"));
        lp.add(new Produit("Andouillette", true, true, 12.6, descrCourte, descrComplete, lc.get(1),"images/menu/andouillette.jpg"));
        
        lp.add(new Produit("Tiramisu", true, false, 2.5, descrCourte, descrComplete, lc.get(2),"images/menu/tiramisu.jpg"));
        lp.add(new Produit("Duo chocolat", true, true, 4.60, descrCourte, descrComplete, lc.get(2),"images/menu/duochocolat.jpg"));
        lp.add(new Produit("Coupe de pamplemousse", true, true, 4.90, descrCourte, descrComplete, lc.get(2),"images/menu/couplepamplemousse.jpg"));
        lp.add(new Produit("Gäteau basque", true, true, 6.3, descrCourte, descrComplete, lc.get(2),"images/menu/gateaubasque.jpg"));
        
        lp.add(new Produit("Mojito", true, true, 5.0, descrCourte, descrComplete, lc.get(3),"images/menu/mojito.jpg"));
        lp.add(new Produit("Coke (cock pour les koreans)", true, false, 2.5, descrCourte, descrComplete, lc.get(3),"images/menu/cocacola.jpg"));
        lp.add(new Produit("Piña colada", true, true, 5.0, descrCourte, descrComplete, lc.get(3),"images/menu/pinacolada.jpg"));
        lp.add(new Produit("Perrier", true, false, 2.0, descrCourte, descrComplete, lc.get(3),"images/menu/perrier.jpg"));
        
        lp.stream().forEach((p) -> {em.persist(p);});
        
        setJeuxCree(true);
    }
    
    @Override
    public List<Produit> selectAllProduit(String categorie) {
        String req = "select p from Produit p where p.categorie.nom =:categorieParam";
        Query qr = em.createQuery(req); 
        qr.setParameter("categorieParam", categorie);
        return qr.getResultList();
    }

    public boolean isJeuxCree() {
        return jeuxCree;
    }

    public void setJeuxCree(boolean jeuxCree) {
        this.jeuxCree = jeuxCree;
    }
    
}
