/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import entites.LigneCommande;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cdi404
 */
@Stateful
public class BeanLigne implements BeanLigneLocal {

    @PersistenceContext(unitName = "montgallette-ejbPU")
    private EntityManager em;
    
    
    //Ajout ALC : Tri des produits pour la cuisine
    @Override
    public List<LigneCommande> triCuisine(List<LigneCommande> liste, List<LigneCommande>superListe){
        List<LigneCommande> listeCuisine = new ArrayList();
        
        for(LigneCommande l : liste){
            if(l.getProduit().isPreparation()){
                listeCuisine.add(l);
            }
        }
        
        superListe.addAll(listeCuisine);
        
        return superListe;
    }

 
}
