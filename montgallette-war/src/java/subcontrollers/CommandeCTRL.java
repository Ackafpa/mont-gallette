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

/**
 *
 * @author cdi404
 */
public class CommandeCTRL implements ControllerInterface {
    BeanCommandeLocal beanCommande = lookupBeanCommandeLocal();

    

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, HttpServlet servlet) {
        String url = "commande.jsp";
        String msg = "Votre commande est vide";
        String action = request.getParameter("action");
        
        //////////////////////////////////////////////////////////////////////////////////////////////////////
        if ("creerDonnees".equalsIgnoreCase(action)) {
           // beanCommande1.creerJeu(); A CREER LE JEU DE TEST !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            request.setAttribute("msg", "Les jeux sont faits");
            url = "commande.jsp";
        }
        Date date = new Date ();
        
        LigneCommande ligne= new LigneCommande(null, 0, null);
        List <LigneCommande> liste = new ArrayList();
        request.setAttribute("liste", liste);
        Commande cde= new Commande(null, null, "12", date);
       //////////////////////////////////////////////////////////////////////////////////////////////////////// 
        
        
        
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

   

}
