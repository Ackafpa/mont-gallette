package entites;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Emplacement implements Serializable, Comparable<Emplacement> {
    private static final long serialVersionUID = 1L;
    
    private boolean dispo;
    
    @Id
    private String numero;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private Collection<Tablee> tablees;
    

    public Emplacement() {
    }

    public Emplacement(boolean dispo, String numero) {
        
        this.dispo = dispo;
        this.numero = numero;
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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numero != null ? numero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Emplacement)) {
            return false;
        }
        Emplacement other = (Emplacement) object;
        if ((this.numero == null && other.numero != null) || (this.numero != null && !this.numero.equals(other.numero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Emplacement[ id=" + numero + " ]";
    }

    @Override
    public int compareTo(Emplacement o) {
           if (Integer.parseInt(this.getNumero())<Integer.parseInt(o.getNumero())){
            return -1;
        }else{
            return 1;
        }
    }

}
