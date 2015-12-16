package entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Commande implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "commande" , cascade=CascadeType.PERSIST)
    private Collection<LigneCommande> produits;

    @ManyToOne
    private Tablee tablee;

    private String numero;
    // @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Temporal(TemporalType.DATE)
    private Date date;

    private double montant;

    public Commande() {
        this.produits = new ArrayList();

    }

    public Commande(Tablee tablee, List<LigneCommande> produits, String numero, Date date) {
        this();
        this.tablee = tablee;
        this.numero = numero;
        this.date = date;

    }

    public Tablee getTablee() {
        return tablee;
    }

    public void setTablee(Tablee tablee) {
        this.tablee = tablee;
    }

    public Collection<LigneCommande> getProduits() {
        return produits;
    }

    public void setProduits(Collection<LigneCommande> produits) {
        this.produits = produits;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
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
        if (!(object instanceof Commande)) {
            return false;
        }
        Commande other = (Commande) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Commande n° "+numero;
    }

    public void setProduits(LigneCommande ligne) {
       //A FAIRE
    }

}
