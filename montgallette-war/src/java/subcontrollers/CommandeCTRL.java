package subcontrollers;

import entites.LigneCommande;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sessionBeans.BeanCommandeLocal;
import sessionBeans.BeanLigneLocal;
import sessionBeans.BeanMenuLocal;
import sessionBeans.BeanTableeLocal;

public class CommandeCTRL implements ControllerInterface {

    BeanLigneLocal beanLigne = lookupBeanLigneLocal();

    BeanTableeLocal beanTablee = lookupBeanTableeLocal();
    BeanMenuLocal beanMenu = lookupBeanMenuLocal();
    BeanCommandeLocal beanCommande = lookupBeanCommandeLocal();


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, HttpServlet servlet) {
        HttpSession session = request.getSession();

        ServletContext application = servlet.getServletContext();

        List<LigneCommande> liste = (List<LigneCommande>) application.getAttribute("listeCuisine");

        if (liste == null) {
            application.setAttribute("listeCuisine", new ArrayList());
        }
        
        
        if ("val".equalsIgnoreCase(action)) {
            
            List<LigneCommande> listeCom = (List<LigneCommande>) session.getAttribute("liste");
            beanCommande.triCuisine(listeCom, liste);

            application.setAttribute("listeCuisine", liste);
        }
            
            url = "client.jsp";
        }
        

         if ("su".equalsIgnoreCase(action)) {
             
           Long id = Long.valueOf(request.getParameter("id"));
              List<LigneCommande> liste = (List<LigneCommande>) session.getAttribute("liste");
              for (LigneCommande l : liste){
                  if (Objects.equals(id, l.getId())) {
                      
                  }
                  } 
               System.out.println("supOK");
               
        
            url="client.jsp";         
      //  }
         }

        
        if("produits".equalsIgnoreCase(action)){
            if(!beanMenu.isJeuxCree()){
            beanMenu.creerJeuxDonnees();
            }
            url="home.jsp";
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////
        
//        if ("aj".equalsIgnoreCase("action")) {
//            // Attendre le bouton ajouter de Kenny
////            Commande commande = (Commande) request.getAttribute("Commande");
////            Produit produit = (Produit) request.getAttribute("Produit");
////            List <String> preferences = (List)request.getAttribute("preferences");            
//
//           
//
//           // Integer etat = 0;       
//     
//        }
     
