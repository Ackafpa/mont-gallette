package entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Tablee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer couverts;
    private Integer numero;
    
    @ManyToMany(mappedBy = "tablees")
    private Collection<Emplacement> emplacements;
    
    @OneToMany(mappedBy= "tablee")
    private Collection<Commande> commandes;
    
//    @Temporal(value=TemporalType.TIMESTAMP)
//    private Date dateFacture;
    
//    private double montantTotal;

    public Tablee() {
        emplacements = new ArrayList();
        commandes = new ArrayList();
        
    }

    public Tablee(int numero, int couverts) {
        this.couverts = couverts;
        this.numero = numero;
    }
    

//    public Tablee( int couverts, Date date, double montantTotal) {
//        
//        this.couverts = couverts;
//        this.dateFacture = date;
//        this.montantTotal = montantTotal;
//    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
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

//    public Date getDateFacture() {
//        return dateFacture;
//    }

//    public void setDateFacture(Date dateFacture) {
//        this.dateFacture = dateFacture;
//    }

//    public double getMontantTotal() {
//        return montantTotal;
//    }

//    public void setMontantTotal() {
//        this.montantTotal = montantTotal;
//    }

    

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
        return "Tablee num = " + numero + ", couverts=" + couverts/* + ", date=" + dateFacture + ", montantTotal=" + montantTotal + "€."*/;
    }

}
