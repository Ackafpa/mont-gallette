/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subcontrollers;

import entites.Commande;
import entites.LigneCommande;
import entites.Produit;
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
        String action = request.getParameter("action");
         if ("aj".equalsIgnoreCase("action")) {
            // Attendre le bouton ajouter de Kenny
//            Commande commande = (Commande) request.getAttribute("Commande");
//            Produit produit = (Produit) request.getAttribute("Produit");
//            List <String> preferences = (List)request.getAttribute("preferences");            

           

           // Integer etat = 0;       
     
        }
     
           if ("su".equalsIgnoreCase(action)) {
               System.out.println("supOK");
        
            url="client.jsp";         
        }
           
        if ("mo".equalsIgnoreCase(action)) {
            System.out.println("moooo ok");
//           String id = request.getParameter("id");
//            String ligne = request.getParameter("ligne");
//            System.out.println(id+"   "+ligne+"------------------------>>>>>>>>>>>>>>>>>>>>>>>>>>>$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
      
       url="client.jsp";
        }
        //////////////////////////////////////////////////////////////////////////////////////////////////////
        if ("creerDonnees".equalsIgnoreCase(action)) {

            List<LigneCommande> liste = beanCommande.listeLigne(beanMenu.selectAllProduit());
            //System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>
            request.setAttribute("liste", liste);
            beanCommande.jeuEssaiCommande(liste, beanTablee.selectTable(2L));
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>   Commande crée");
            
            url = "client.jsp";
        }
        

        

        
        if("produits".equalsIgnoreCase(action)){
            if(!beanMenu.isJeuxCree()){
            beanMenu.creerJeuxDonnees();
            }
            url="home.jsp";
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////
        
        if ("aj".equalsIgnoreCase("action")) {
            // Attendre le bouton ajouter de Kenny
//            Commande commande = (Commande) request.getAttribute("Commande");
//            Produit produit = (Produit) request.getAttribute("Produit");
//            List <String> preferences = (List)request.getAttribute("preferences");            

           

           // Integer etat = 0;       
     
        }
     
        System.out.println(url);
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

   
