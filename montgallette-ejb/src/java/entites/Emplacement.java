package entites;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Emplacement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                //--> idem numero de table ??
    private boolean dispo;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private Collection<Tablee> tablees;
    

    public Emplacement() {
    }

    public Emplacement(Long id, boolean dispo) {
        this.id = id;
        this.dispo = dispo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isDispo() {
        return dispo;
    }

    public void setDispo(boolean dispo) {
        this.dispo = dispo;
    }

    public Collection<Tablee> getTablees() {
        return tablees;
    }

    public void setTablees(Collection<Tablee> tablees) {
        this.tablees = tablees;
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
        if (!(object instanceof Emplacement)) {
            return false;
        }
        Emplacement other = (Emplacement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Emplacement[ id=" + id + " ]";
    }
    
}
