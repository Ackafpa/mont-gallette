
package sessionBeans;

import entites.Emplacement;
import entites.Tablee;
import javax.ejb.Local;

@Local
public interface BeanTableeLocal {

    public void modifCouverts(Tablee t, int n);
    public double addition(Tablee t);
    public void jeuTables();
    public Tablee selectTable(Long l);
    public void persist(Tablee t);
    public Tablee recupTablee(Emplacement e);
    public Tablee creerTablee(Integer couverts, Emplacement e);
}
