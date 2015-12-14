/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import entites.Commande;
import entites.LigneCommande;
import entites.Produit;
import entites.Tablee;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cdi404
 */
@Local
public interface BeanCommandeLocal {

    public void jeuEssaiCommande(List<LigneCommande> liste, Tablee t);

    public List<LigneCommande> listeLigne(List<Produit> produits);

    public Commande validerCommande(Tablee t, List<LigneCommande> produits, String numero, Date date);

}
