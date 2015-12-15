/*
 * Licensed to Kenneth Pino
 */
package sessionBeans;

import entites.Produit;
import javax.ejb.Local;

/**
 *
 * @author cdi411
 */
@Local
public interface BeanProduitLocal {

    public Produit trouverProduit(String id);

}
