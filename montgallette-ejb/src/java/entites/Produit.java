package entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
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
    private boolean preparation;
    private Double prixHT;
    private String descriptionCourte;
    @Column(length = 5000)
    private String descriptionComplete;
    private String photoURL;
    
    @ManyToOne
    private Categorie categorie;
    
    @ManyToMany
    private Collection<Offre> offres;
    
//    @ManyToMany(mappedBy = "produits")
//    private Collection<Garniture> garnitures;

    public Produit() {
        offres = new ArrayList();
//        garnitures = new ArrayList();   
    }

    public Produit(String nom, boolean dispo, boolean preparation, Double prixHT, String descriptionCourte, String descriptionComplete, Categorie categorie, String photoURL) {
        this();
        this.nom = nom;
        this.dispo = dispo;
        this.preparation = preparation;
        this.prixHT = prixHT;
        this.descriptionCourte = descriptionCourte;
        this.descriptionComplete = descriptionComplete;
        this.categorie = categorie;
        this.photoURL = photoURL;
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

    public boolean isPreparation() {
        return preparation;
    }

    public void setPreparation(boolean preparation) {
        this.preparation = preparation;
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

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

//    public Collection<Garniture> getGarnitures() {
//        return garnitures;
//    }
//
//    public void setGarnitures(Collection<Garniture> garnitures) {
//        this.garnitures = garnitures;
//    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
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
        return nom ;
    }
}
