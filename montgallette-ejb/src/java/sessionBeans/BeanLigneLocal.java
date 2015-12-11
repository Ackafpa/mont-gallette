/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import entites.LigneCommande;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cdi404
 */
@Local
public interface BeanLigneLocal {

    public List<LigneCommande> triCuisine(List<LigneCommande> liste, List<LigneCommande> superListe);

    
}
