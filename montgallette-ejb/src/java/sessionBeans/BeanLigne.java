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
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author cdi404
 */
@Stateful
public class BeanLigne implements BeanLigneLocal {

    @PersistenceContext(unitName = "montgallette-ejbPU")
    private EntityManager em;

    public LigneCommande chercherLigne(Integer id) {
        System.out.println("CHERCHER LIGNE OOOOOOOOOOOOOOOOOOOOOOKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK");
        String req = "select l from LigneCommande l where id = :id";
        Query qr = em.createQuery(req);
        qr.setParameter("id", id);

        try {
            LigneCommande l = (LigneCommande) qr.getSingleResult();
            return l;
        } catch (NoResultException ex) {
            System.out.println("erroorrrrrrrrrrrrrrrrr==================================='((((((((((((((((((((((((((((((((((((((((((((((((((((((");
        }
        return null;

    }
    //Ajout ALC : Tri des produits pour la cuisine

    @Override
    public List<LigneCommande> triCuisine(List<LigneCommande> liste, List<LigneCommande> superListe) {
        List<LigneCommande> listeCuisine = new ArrayList();

        for (LigneCommande l : liste) {
            if (l.getProduit().isPreparation()) {
                listeCuisine.add(l);
            }
        }

        superListe.addAll(listeCuisine);

        return superListe;

    }

    @Override
    public LigneCommande sortirLigne(LigneCommande lc, String li) {
        while (!li.equals(String.valueOf(lc.getId()))) {
            if (li.equals(String.valueOf(lc.getId()))) {
                System.out.println("OUI" + li);

            } else {
                System.out.println(lc.getId());
                System.out.println("NON");
            }

        }

        return lc;

    }
}
