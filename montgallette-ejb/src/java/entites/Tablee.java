package entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Tablee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer couverts;
    
    
    @ManyToMany(mappedBy = "tablees")
    private Collection<Emplacement> emplacements;
    
    @OneToMany(mappedBy= "tablee")
    private Collection<Commande> commandes;
   
    private double montantTotal;

    public Tablee() {
        emplacements = new ArrayList();
        commandes = new ArrayList();
        
    }

    public Tablee(Integer couverts, Collection<Emplacement> emplacements) {
        this.couverts = couverts;
        this.emplacements = emplacements;
    }

    

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCouverts() {
        return couverts;
    }

    public void setCouverts(int couverts) {
        this.couverts = couverts;
    }

    public Collection<Emplacement> getEmplacements() {
        return emplacements;
    }

    public void setEmplacements(Collection<Emplacement> emplacements) {
        this.emplacements = emplacements;
    }

    public Collection<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(Collection<Commande> commandes) {
        this.commandes = commandes;
    }


    public double getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal() {
        this.montantTotal = montantTotal;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tablee)) {
            return false;
        }
        Tablee other = (Tablee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tablee id = " + id + ", couverts=" + couverts;
    }

}
