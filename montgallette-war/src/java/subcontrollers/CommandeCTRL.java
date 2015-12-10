/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subcontrollers;

import entites.Commande;
import entites.LigneCommande;
import entites.Produit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sessionBeans.BeanCommandeLocal;
import sessionBeans.BeanMenuLocal;
import sessionBeans.BeanTableeLocal;

/**
 *
 * @author cdi404
 */
public class CommandeCTRL implements ControllerInterface {
    BeanTableeLocal beanTablee = lookupBeanTableeLocal();
    BeanMenuLocal beanMenu = lookupBeanMenuLocal();
    BeanCommandeLocal beanCommande = lookupBeanCommandeLocal();

    

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, HttpServlet servlet) {
        String url = "home.jsp";
        String msg = "Votre commande est vide";
        String action = request.getParameter("action");
        
        //////////////////////////////////////////////////////////////////////////////////////////////////////
        if ("creerDonnees".equalsIgnoreCase(action)) {
            System.err.println("Juste comme ça");
           // beanCommande1.creerJeu(); A CREER LE JEU DE TEST !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            
            
            
            
            List<LigneCommande> liste = beanCommande.listeLigne(beanMenu.selectAllProduit());
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>    Liste créee");
            request.setAttribute("liste", liste);
            beanCommande.jeuEssaiCommande(liste, beanTablee.selectTable(2));
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>   Commande crée");
            request.setAttribute("msg", "Les jeux sont faits");
            url = "commande.jsp";
        }
        
       //////////////////////////////////////////////////////////////////////////////////////////////////////// 
        if("jeuTables".equalsIgnoreCase(action)){
            beanTablee.jeuTables();
            url="home.jsp";
        }
        
        if("produits".equalsIgnoreCase(action)){
            beanMenu.creerJeuxDonnees();
            url="home.jsp";
        }
        
        
        if ("ajouter".equalsIgnoreCase("action")) {
            
            Commande commande = (Commande) request.getAttribute("Commande");
            Produit produit = (Produit) request.getAttribute("Produit");
            List <String> preferences = (List)request.getAttribute("preferences");            

            //List <Garnitures> garnitures =(List) request.getAttribute("garnitures");

            Integer etat = 0;
            //beanCommande1.ajouterLigne(null, 0, null, preferences, garnitures);
//public Commande ajouterLigne(Produit produit, Integer etat, Commande commande, List<String> preferences, List<Garniture> garnitures) {
     
        }
        if ("supprimer".equalsIgnoreCase("action")) {
            request.getParameter("id");
            request.getParameter("ligne");

          //  beanCommande.supprimerLigne(null, null);

        }
        if ("modifier".equalsIgnoreCase("action")) {
            
//récupérer la ligne     

        }

        return url;

    }

    private BeanCommandeLocal lookupBeanCommandeLocal() {
        try {
            Context c = new InitialContext();
            return (BeanCommandeLocal) c.lookup("java:global/montgallette/montgallette-ejb/BeanCommande!sessionBeans.BeanCommandeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private BeanMenuLocal lookupBeanMenuLocal() {
        try {
            Context c = new InitialContext();
            return (BeanMenuLocal) c.lookup("java:global/montgallette/montgallette-ejb/BeanMenu!sessionBeans.BeanMenuLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private BeanTableeLocal lookupBeanTableeLocal() {
        try {
            Context c = new InitialContext();
            return (BeanTableeLocal) c.lookup("java:global/montgallette/montgallette-ejb/BeanTablee!sessionBeans.BeanTableeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

   

}
