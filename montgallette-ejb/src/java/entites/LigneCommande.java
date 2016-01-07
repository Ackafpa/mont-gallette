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

@Entity
public class LigneCommande implements Serializable {

    private static final long serialVersionUID = 1L;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    private static int compteur = 0;
    //private int idLocal = 0;
    
    @OneToOne
    private Produit produit;

    private Collection<String> preferences;
    private Integer etat;

    @ManyToMany
    private Collection<Garniture> garnitures;

    @ManyToOne(cascade=CascadeType.PERSIST)
    private Commande commande;

    public LigneCommande() {
     garnitures = new ArrayList();
     preferences = new ArrayList();
     compteur++;
  
    }

    public LigneCommande(Produit produit, Integer etat, Commande commande) {
        this();
        this.produit = produit;
        this.etat = etat;
        this.commande = commande;
//        this.idLocal = (int) (commande.getId()+compteur);
        
    }

//      --> C'EST QUOI ?????????????????????????
    
//    public String S(){
//        
//        String s=null;
//       if (etat ==null)
//           s="validé";
//        if (etat == 0){
//            s= "validé";
//        }
//        if(etat == 1){
//            s= "en préparation";
//        }
//        if (etat == 2){
//             s= " prêt"; 
//        }
//        else
//            s="erreur fonction S";
//            
//        return s;
//    }
//    
   
    @Override
    public String toString() {
        
       // String s = this.toString(etat);
        return produit + " " + preferences + " " + garnitures + " est ";
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

    public static int getCompteur() {
        return compteur;
    }

    public static void setCompteur(int compteur) {
        LigneCommande.compteur = compteur;
    }
/*
    public int getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(int idLocal) {
        this.idLocal = idLocal;
    }
*/
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
