/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import entites.Commande;
import entites.LigneCommande;
import entites.Produit;
import java.util.Collection;
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

    public Commande creerLigne(Produit produit, Collection<String> preferences, Integer etat, Commande commande) {

        LigneCommande ligne = new LigneCommande(produit, preferences, etat, commande);
        
        if (commande != null) {


            Collection<LigneCommande> p = commande.getProduits();           
            em.persist(p);

        } else {
            commande = new Commande();
            commande.setProduits((Collection<LigneCommande>) ligne);
            
            em.persist(commande);
      
            
        }
        return commande;
            

        }
       
    }


