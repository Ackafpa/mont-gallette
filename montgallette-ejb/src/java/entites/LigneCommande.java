package entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author cdi404
 */
@Entity
public class LigneCommande implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Produit produit;

    private Collection<String> preferences;
    private Integer etat;

    @ManyToMany
    private Collection<Garniture> garnitures;

    @ManyToOne(cascade=CascadeType.PERSIST)
    private Commande commande;

    public LigneCommande() {
      //  garnitures = new ArrayList();
     //preferences = new ArrayList();
    }

    

    public LigneCommande(Produit produit, Integer etat, Commande commande) {
        
        this();
        this.produit = produit;
        this.etat = etat;
        this.commande = commande;
    }

    
//    public String toString(Integer etat){
//        
//        String s=null;
//       
//        if (etat == 0){
//            s= "validé";
//        }
//        if(etat == 1){
//            s= "en préparation";
//        }
//        if (etat == 2){
//             s= "est prêt"; 
//        }
//        return s;
//    }
    String s=null;
    @Override
    public String toString() {
        
       // String s = this.toString(etat);
        return produit + " " + preferences + " " + garnitures + " est " + s;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   

    public Integer getEtat() {
        return etat;
    }

    public void setEtat(Integer etat) {
        this.etat = etat;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Collection<String> getPreferences() {
        return preferences;
    }

    public void setPreferences(Collection<String> preferences) {
        this.preferences = preferences;
    }

    public Collection<Garniture> getGarnitures() {
        return garnitures;
    }

    public void setGarnitures(Collection<Garniture> garnitures) {
        this.garnitures = garnitures;
    }
    
    

}
