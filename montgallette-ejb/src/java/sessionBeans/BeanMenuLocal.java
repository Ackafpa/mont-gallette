/*
 * Licensed to Kenneth Pino
 */
package sessionBeans;

import entites.Produit;
import java.util.List;
import javax.ejb.Local;

@Local
public interface BeanMenuLocal {
    public void creerJeuxDonnees();
    public List<Produit> selectAllProduit(String categorie);
    public boolean isJeuxCree();
}
