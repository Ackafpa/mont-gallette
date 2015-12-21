package subcontrollers;

import entites.Commande;
import entites.Emplacement;
import entites.LigneCommande;
import entites.Produit;
import entites.Tablee;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
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
import sessionBeans.BeanEmplacementLocal;
import sessionBeans.BeanLigneLocal;
import sessionBeans.BeanMenuLocal;
import sessionBeans.BeanProduitLocal;
import sessionBeans.BeanTableeLocal;

public class CommandeCTRL implements ControllerInterface {

    BeanEmplacementLocal beanEmplacement = lookupBeanEmplacementLocal1();
    BeanProduitLocal beanProduit = lookupBeanProduitLocal();
    BeanLigneLocal beanLigne = lookupBeanLigneLocal();
    BeanTableeLocal beanTablee = lookupBeanTableeLocal();
    BeanMenuLocal beanMenu = lookupBeanMenuLocal();
    BeanCommandeLocal beanCommande = lookupBeanCommandeLocal();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, HttpServlet servlet) {

        String url = "home.jsp";
        HttpSession session = request.getSession();
        ServletContext application = servlet.getServletContext();
        String action = request.getParameter("action");
        String table = request.getParameter("table");
        String msgCommande = "Cliquez sur ajouter pour remplir votre commande";
        request.setAttribute("msgCommande", msgCommande);

        List<LigneCommande> listeCuisine = (List<LigneCommande>) application.getAttribute("listeCuisine");

        if (listeCuisine == null) {
            application.setAttribute("listeCuisine", new ArrayList());
        }

        if ("creerTable".equalsIgnoreCase(action)) {
            if (beanTablee.recupTablee(beanEmplacement.recupEmplacement(table)) == null) {
                
                request.setAttribute("creer", true);
                request.setAttribute("table", table);
                url = "garcon.jsp";
            } else {
                request.setAttribute("table", table);
                request.setAttribute("section", "commande.acka");
                request.setAttribute("action", "creerCo");
                url = "garcon.jsp";
            }
        }

        if ("creerCo".equalsIgnoreCase(action)) {
            if (beanTablee.recupTablee(beanEmplacement.recupEmplacement(table)) == null) {
                Integer i = Integer.decode(request.getParameter("couverts"));
                HashMap<String, Emplacement> HMemp = (HashMap<String, Emplacement>) application.getAttribute("HMemp");
                
                beanEmplacement.modifierDispo(HMemp, table);
                application.setAttribute("HMemp", HMemp);
                
                application.setAttribute("lemp", beanEmplacement.sort(HMemp));
                
                
                Tablee t = beanTablee.creerTablee(i, beanEmplacement.recupEmplacement(table));
                
                

                session.setAttribute("commande", beanCommande.creerCommande(t));
                ///J'ai besoin d'un créer commande qui renvoie une commande pas un numéro de commande
                session.setAttribute("cde", beanCommande.creerCommandeC(t));
                url = "client.jsp";
            } else {
                session.setAttribute("commandes", beanCommande.recupCommande(beanTablee.recupTablee(beanEmplacement.recupEmplacement(table))));
                url = "client.jsp";
            }
        }
        
        //Nouvelle méthode CHRIS
        if ("ajouterLigne".equalsIgnoreCase(action)) {
        Commande c = (Commande) session.getAttribute("cde");
        Produit p = beanProduit.trouverProduit(request.getParameter("produit"));
        Collection <LigneCommande> liste = c.getProduits();
        
        
        liste.add(beanLigne.creerLigne(p, c));
        c.setProduits(beanLigne.creerLigne(p, c));
        Long id = c.getId();
        session.setAttribute("idCommande", id);
        
        session.setAttribute("liste", liste);
        c.setProduits(liste);
        beanCommande.persist(c);
        request.setAttribute("liste", liste);
        url="client.jsp";
     
        }  // Fin nouvelle fonction CHRIS

        if ("val".equalsIgnoreCase(action)) {

            List<LigneCommande> listeCom = (List<LigneCommande>) session.getAttribute("liste");

            beanCommande.triCuisine(listeCom, listeCuisine);
            Commande c = (Commande) session.getAttribute("Commande");
            beanCommande.persist(c);
            application.setAttribute("listeCuisine", listeCuisine);
        }

        if ("su".equalsIgnoreCase(action)) {
            Commande c = (Commande) session.getAttribute("cde");
            ////////////////////////////
            Long i = c.getId();
            System.out.println(i);
            Produit p = beanProduit.trouverProduit("3");
            LigneCommande llb=(LigneCommande) beanLigne.creerLigne(p, c);
            int idid= llb.getIdLocal();
            System.out.println("LLLELELELLELELE"+idid+"     et i est égale à :"+i);
            ////////////////////////
            String li = request.getParameter("ligne");
            List<LigneCommande> listee = (List<LigneCommande>) session.getAttribute("liste");
          
            for (LigneCommande lc : listee) {
                if (lc.getIdLocal() == Integer.valueOf(li) ) {
                    LigneCommande lcc = beanLigne.sortirLigne(lc, li);
                   
                    session.setAttribute("lcc", lcc);
                }
            }
            LigneCommande lcc = (LigneCommande) session.getAttribute("lcc");
            listee.remove(lcc);
            session.setAttribute("liste", listee);
 c = (Commande)session.getAttribute("cde");
 c.setProduits(listee);
            url = "client.jsp";
        }

        if ("mo".equalsIgnoreCase(action)) {
            System.out.println("moooo ok");
            //String id = request.getParameter("id");
            //String ligne = request.getParameter("ligne");
            //System.out.println(id+"   "+ligne+"------------------------>>>>>>>>>>>>>>>>>>>>>>>>>>>$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
            url = "client.jsp";
        }
        
        if ("creerDonnees".equalsIgnoreCase(action)) {

            //modifiee TEMP par Kenneth
            List<LigneCommande> listeLigne = beanCommande.listeLigne(beanMenu.selectAllProduit("boisson"));

            session.setAttribute("liste", listeLigne);
            beanCommande.jeuEssaiCommande(listeLigne, beanTablee.selectTable(2L));

            //A changer, doit s'executer a chaque commande passée
            beanCommande.triCuisine(listeLigne, listeCuisine);
            application.setAttribute("listeCuisine", listeCuisine);

            url = "home.jsp";
        }

        if ("produits".equalsIgnoreCase(action)) {
            if (!beanMenu.isJeuxCree()) {
                beanMenu.creerJeuxDonnees();
            }
            url = "home.jsp";
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

    private BeanLigneLocal lookupBeanLigneLocal() {
        try {
            Context c = new InitialContext();
            return (BeanLigneLocal) c.lookup("java:global/montgallette/montgallette-ejb/BeanLigne!sessionBeans.BeanLigneLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private BeanProduitLocal lookupBeanProduitLocal() {
        try {
            Context c = new InitialContext();
            return (BeanProduitLocal) c.lookup("java:global/montgallette/montgallette-ejb/BeanProduit!sessionBeans.BeanProduitLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private BeanEmplacementLocal lookupBeanEmplacementLocal() {
        try {
            Context c = new InitialContext();
            return (BeanEmplacementLocal) c.lookup("java:global/montgallette/montgallette-ejb/BeanEmplacement!sessionBeans.BeanEmplacementLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private BeanEmplacementLocal lookupBeanEmplacementLocal1() {
        try {
            Context c = new InitialContext();
            return (BeanEmplacementLocal) c.lookup("java:global/montgallette/montgallette-ejb/BeanEmplacement!sessionBeans.BeanEmplacementLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
