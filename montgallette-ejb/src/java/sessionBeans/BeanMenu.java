package sessionBeans;

import entites.Categorie;
import entites.Offre;
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
    public void creerJeuxDonnees() {

        String descrCourte = "Suspendisse potenti. In hac habitasse platea dictumst.";
        String descrComplete = "Donec finibus laoreet finibus. Phasellus ut ante tincidunt, venenatis ante eget, volutpat risus."; // Sed viverra at justo vitae pulvinar. Curabitur facilisis lectus ac justo mollis luctus. Sed suscipit sapien et massa semper, nec interdum libero condimentum. Curabitur mi mauris, convallis feugiat enim posuere, accumsan rutrum quam. Aenean gravida libero lorem, nec sagittis justo molestie ut.";
        List<Produit> lp = new ArrayList();
        List<Categorie> lc = new ArrayList();
        List<Offre> lo = new ArrayList();

        //Creer categories
        lc.add(new Categorie("Entree"));
        lc.add(new Categorie("Plat"));
        lc.add(new Categorie("Dessert"));
        lc.add(new Categorie("Boisson"));

        //Creer offres
        lo.add(new Offre("Entrée + plat + boisson", "midi1", 13.95));
        lo.add(new Offre("Entrée + plat + dessert + boisson", "midi2", 15.95));
        lo.add(new Offre("Plat + dessert + boisson", "midi3", 11.95));

        //CREER PRODUITS
        //Creer entrees
        lp.add(new Produit("Soupe au poitiron au compté", true, true, 5.95, descrCourte, descrComplete, lc.get(0), "images/menu/soupepoitiron.jpg"));
        lp.add(new Produit("Grande assiette à partager", true, true, 12.95, descrCourte, descrComplete, lc.get(0), "images/menu/assietteparteger.jpg"));
        lp.add(new Produit("Terrine de champagne", true, true, 4.50, descrCourte, descrComplete, lc.get(0), "images/menu/terrinecampagne.jpg"));
        lp.add(new Produit("Faisselle de fromage blanc", true, true, 5.95, descrCourte, descrComplete, lc.get(0), "images/menu/faissellefblanc.jpg"));
        lp.add(new Produit("Tartare de saumon et tomate", true, true, 6.50, descrCourte, descrComplete, lc.get(0), "images/menu/tartaresaumon.jpg"));
        lp.add(new Produit("Tortilla española", true, true, 5.50, descrCourte, descrComplete, lc.get(0), "images/menu/tortillaespanola.jpg"));
        //Creer plats
        lp.add(new Produit("Steak dans la hampe", true, true, 13.50, descrCourte, descrComplete, lc.get(1), "images/menu/steakhampe.jpg"));
        lp.add(new Produit("Tartare de boef", true, true, 12.50, descrCourte, descrComplete, lc.get(1), "images/menu/tartareboeuf.jpg"));
        lp.add(new Produit("Pavé de rumsteak", true, true, 15.95, descrCourte, descrComplete, lc.get(1), "images/menu/paverumsteak.jpg"));
        lp.add(new Produit("Andouillette", true, true, 12.50, descrCourte, descrComplete, lc.get(1), "images/menu/andouillette.jpg"));
        lp.add(new Produit("Poulet a la normande", true, true, 12.50, descrCourte, descrComplete, lc.get(1), "images/menu/pouletnormande.jpg"));
        lp.add(new Produit("Bavette au poivre", true, true, 12.95, descrCourte, descrComplete, lc.get(1), "images/menu/bavettepoivre.jpg"));
        lp.add(new Produit("Daurade au citron", true, true, 13.95, descrCourte, descrComplete, lc.get(1), "images/menu/dauradecitron.jpg"));
        //Creer desserts
        lp.add(new Produit("Tiramisu", true, false, 4.95, descrCourte, descrComplete, lc.get(2), "images/menu/tiramisu.jpg"));
        lp.add(new Produit("Duo chocolat", true, true, 4.50, descrCourte, descrComplete, lc.get(2), "images/menu/duochocolat.jpg"));
        lp.add(new Produit("Coupe de pamplemousse", true, true, 4.99, descrCourte, descrComplete, lc.get(2), "images/menu/couplepamplemousse.jpg"));
        lp.add(new Produit("Gäteau basque", true, true, 3.95, descrCourte, descrComplete, lc.get(2), "images/menu/gateaubasque.jpg"));
        lp.add(new Produit("Crème brûlée", true, true, 5.95, descrCourte, descrComplete, lc.get(2), "images/menu/cremebrulee.jpg"));
        lp.add(new Produit("Chocolate con churros", true, true, 4.95, descrCourte, descrComplete, lc.get(2), "images/menu/chocolatechurros.jpg"));
        //Creer boissons
        lp.add(new Produit("Mojito", true, true, 4.95, descrCourte, descrComplete, lc.get(3), "images/menu/mojito.jpg"));
        lp.add(new Produit("Cocacola", true, false, 2.50, descrCourte, descrComplete, lc.get(3), "images/menu/cocacola.jpg"));
        lp.add(new Produit("Piña colada", true, true, 4.95, descrCourte, descrComplete, lc.get(3), "images/menu/pinacolada.jpg"));
        lp.add(new Produit("Perrier", true, false, 1.95, descrCourte, descrComplete, lc.get(3), "images/menu/perrier.jpg"));
        lp.add(new Produit("Nestea", true, false, 2.50, descrCourte, descrComplete, lc.get(3), "images/menu/nestea.jpg"));
        lp.add(new Produit("Jus d'orange", true, false, 2.95, descrCourte, descrComplete, lc.get(3), "images/menu/jusorange.jpg"));

        //LIER PRODUITS AUX OFFRES
        //Lier entrees
        lp.get(0).getOffres().add(lo.get(0));
        lp.get(0).getOffres().add(lo.get(1));
        lp.get(2).getOffres().add(lo.get(0));
        lp.get(2).getOffres().add(lo.get(1));
        lp.get(3).getOffres().add(lo.get(0));
        lp.get(3).getOffres().add(lo.get(1));
        lp.get(5).getOffres().add(lo.get(0));
        lp.get(5).getOffres().add(lo.get(1));
        //Lier plats
        lp.get(10).getOffres().add(lo.get(0));
        lp.get(10).getOffres().add(lo.get(1));
        lp.get(10).getOffres().add(lo.get(2));
        lp.get(11).getOffres().add(lo.get(0));
        lp.get(11).getOffres().add(lo.get(1));
        lp.get(11).getOffres().add(lo.get(2));
        lp.get(12).getOffres().add(lo.get(0));
        lp.get(12).getOffres().add(lo.get(1));
        lp.get(12).getOffres().add(lo.get(2));
        //Lier desserts
        lp.get(13).getOffres().add(lo.get(1));
        lp.get(13).getOffres().add(lo.get(2));
        lp.get(14).getOffres().add(lo.get(1));
        lp.get(14).getOffres().add(lo.get(2));
        lp.get(15).getOffres().add(lo.get(1));
        lp.get(15).getOffres().add(lo.get(2));
        lp.get(16).getOffres().add(lo.get(1));
        lp.get(16).getOffres().add(lo.get(2));
        lp.get(17).getOffres().add(lo.get(1));
        lp.get(17).getOffres().add(lo.get(2));
        lp.get(18).getOffres().add(lo.get(1));
        lp.get(18).getOffres().add(lo.get(2));
        //Lier boissons
        lp.get(19).getOffres().add(lo.get(0));
        lp.get(19).getOffres().add(lo.get(1));
        lp.get(19).getOffres().add(lo.get(2));
        lp.get(20).getOffres().add(lo.get(0));
        lp.get(20).getOffres().add(lo.get(1));
        lp.get(20).getOffres().add(lo.get(2));
        lp.get(21).getOffres().add(lo.get(0));
        lp.get(21).getOffres().add(lo.get(1));
        lp.get(21).getOffres().add(lo.get(2));
        lp.get(22).getOffres().add(lo.get(0));
        lp.get(22).getOffres().add(lo.get(1));
        lp.get(22).getOffres().add(lo.get(2));
        lp.get(23).getOffres().add(lo.get(0));
        lp.get(23).getOffres().add(lo.get(1));
        lp.get(23).getOffres().add(lo.get(2));
        lp.get(24).getOffres().add(lo.get(0));
        lp.get(24).getOffres().add(lo.get(1));
        lp.get(24).getOffres().add(lo.get(2));

        lc.stream().forEach((c) -> {
            em.persist(c);
        });
        lo.stream().forEach((o) -> {
            em.persist(o);
        });
        lp.stream().forEach((p) -> {
            em.persist(p);
        });

        setJeuxCree(true);
    }

    @Override
    public List<Produit> selectAllProduit(String categorie) {
        String req;
        
        if("formule".equals(categorie)){
            req = "select po from produit_offre po";
            //select * from PRODUIT p join PRODUIT_OFFRE po on p.id = po.produits_ID
        } else {
            req = "select p from Produit p where p.categorie.nom =:categorieParam";
        }

        Query qr = em.createQuery(req);
        qr.setParameter("categorieParam", categorie);
        return qr.getResultList();
    }

    @Override
    public boolean isJeuxCree() {
        return jeuxCree;
    }

    public void setJeuxCree(boolean jeuxCree) {
        this.jeuxCree = jeuxCree;
    }

}
