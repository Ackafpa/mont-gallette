package entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Produit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private boolean dispo;
    private Double prixHT;
    private String descriptionCourte;
    private String descriptionComplete;

    @ManyToOne
    private Categorie categorie;

    @ManyToMany(mappedBy = "produits")
    private Collection<Offre> offres;

    @ManyToMany
    private Collection<Garniture> garnitures;

    public Produit() {
        
        offres = new ArrayList();
        garnitures = new ArrayList();
        
    }

    public Produit(String nom, boolean dispo, Double prixHT, String descriptionCourte, String descriptionComplete, Categorie categorie, Collection<Offre> offres) {
        
        this ();
        this.nom = nom;
        this.dispo = dispo;
        this.prixHT = prixHT;
        this.descriptionCourte = descriptionCourte;
        this.descriptionComplete = descriptionComplete;
        this.categorie = categorie;
        this.offres = offres;
        
    }

    

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean isDispo() {
        return dispo;
    }

    public void setDispo(boolean dispo) {
        this.dispo = dispo;
    }

    public Double getPrixHT() {
        return prixHT;
    }

    public void setPrixHT(Double prixHT) {
        this.prixHT = prixHT;
    }

    public String getDescriptionCourte() {
        return descriptionCourte;
    }

    public void setDescriptionCourte(String descriptionCourte) {
        this.descriptionCourte = descriptionCourte;
    }

    public String getDescriptionComplete() {
        return descriptionComplete;
    }

    public void setDescriptionComplete(String descriptionComplete) {
        this.descriptionComplete = descriptionComplete;
    }

    public Collection<Offre> getOffres() {
        return offres;
    }

    public void setOffres(Collection<Offre> offres) {
        this.offres = offres;
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
        if (!(object instanceof Produit)) {
            return false;
        }
        Produit other = (Produit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Produits : " + nom + " ]";
    }

}
