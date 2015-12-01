
package entites;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author cdi404
 */
@Entity
public class LigneCommande implements Serializable {
  
    @Id
    private Long id;
   

    private Integer qte;
    
   
    
    @ManyToOne
    private Commande commande;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LigneCommande(Long id, Integer qte, Commande commande) {
        this.id = id;
        this.qte = qte;
        this.commande = commande;
    }

    public LigneCommande() {
    }

    public Integer getQte() {
        return qte;
    }

    public void setQte(Integer qte) {
        this.qte = qte;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }
    
    
    
    
    
    
  


   
    
}
