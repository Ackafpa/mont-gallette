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
import sessionBeans.BeanMenuLocal;
import sessionBeans.BeanTableeLocal;

public class CommandeCTRL implements ControllerInterface {

    BeanTableeLocal beanTablee = lookupBeanTableeLocal();
    BeanMenuLocal beanMenu = lookupBeanMenuLocal();
    BeanCommandeLocal beanCommande = lookupBeanCommandeLocal();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, HttpServlet servlet) {
        String url = "home.jsp";

        HttpSession session = request.getSession();

        ServletContext application = servlet.getServletContext();
        String action = request.getParameter("action");

        List<LigneCommande> liste = (List<LigneCommande>) application.getAttribute("listeCuisine");

        if (liste == null) {
            application.setAttribute("listeCuisine", new ArrayList());
        }

        if ("val".equalsIgnoreCase(action)) {

            List<LigneCommande> listeCom = (List<LigneCommande>) session.getAttribute("liste");
            beanCommande.triCuisine(listeCom, liste);

            application.setAttribute("listeCuisine", liste);
        }

        if ("su".equalsIgnoreCase(action)) {

            Long id = Long.valueOf(request.getParameter("id"));
            List<LigneCommande> listeComm = (List<LigneCommande>) session.getAttribute("liste");
            for (LigneCommande l : listeComm) {
                if (Objects.equals(id, l.getId())) {

                }
            }
            System.out.println("supOK");

            url = "client.jsp";
            //  }
        }

        if ("produits".equalsIgnoreCase(action)) {
            if (!beanMenu.isJeuxCree()) {
                beanMenu.creerJeuxDonnees();
            }
            url = "home.jsp";
        }
        if ("creerDonnees".equalsIgnoreCase(action)) {

            List<LigneCommande> listeLigne = beanCommande.listeLigne(beanMenu.selectAllProduit());

            session.setAttribute("liste", listeLigne);
            beanCommande.jeuEssaiCommande(listeLigne, beanTablee.selectTable(2L));
            
            //A changer, doit s'executer a chaque commande passée
            beanCommande.triCuisine(listeLigne, liste);
            application.setAttribute("listeCuisine", liste);

            url = "home.jsp";
        }

        if ("produits".equalsIgnoreCase(action)) {
            if (!beanMenu.isJeuxCree()) {
                beanMenu.creerJeuxDonnees();
            }
            url = "home.jsp";
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

