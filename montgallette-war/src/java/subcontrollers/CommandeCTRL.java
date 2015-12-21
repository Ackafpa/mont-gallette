package subcontrollers;

import entites.Commande;
import entites.LigneCommande;
import entites.Produit;
import entites.Tablee;
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
                
                Tablee t = beanTablee.creerTablee(i, beanEmplacement.recupEmplacement(table));
                
                session.setAttribute("OQP", beanEmplacement.recupEmplacement(table).isDispo());

                session.setAttribute("commande", beanCommande.creerCommande(t));
                

                url = "garcon.jsp";
            } else {
                session.setAttribute("commandes", beanCommande.recupCommande(beanTablee.recupTablee(beanEmplacement.recupEmplacement(table))));
                url = "client.jsp";
            }
        }

//ANTHO
        if("modifierEtat".equalsIgnoreCase(action)){
            
            
            
//            LigneCommande lc = request.getParameter("ligne");
//            changerEtatValider(lc);
            
        }
//ANTHO FIN 
        
        
        
        //Nouvelle méthode CHRIS
        if ("ajouterLigne".equalsIgnoreCase(action)) {
            String id = request.getParameter("produit");
            System.out.println("IDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD"+id);
            
            // IL N'Y A PAS ENCORE DE LISTE DE CONSTRUITE DANS LA SESSION!!!
            // ET LA, TU PRENDS LA LISTE DESTINEE A LA CUISINE
            /*liste = (List) session.getAttribute("liste");
            System.out.println("LISTE"+liste);*/
            
            /*REGARDE LE beanCommande, JE T'AI AJOUTE QUELQUES FONCTIONS PRATIQUES*/
            
           //A VOIR POUR UTILISER LA FONCTION ajouterLigne PRESENTE DANS beanCommande
            
            
            Produit p = beanProduit.trouverProduit(id);//ERREUR
            System.out.println("PRODUIT"+p);
            
            //FONCTION AJOUTER PREFERENCES ET GARNITUES A FAIRE
            
            Commande c = (Commande) session.getAttribute("commande");
            LigneCommande lc= beanLigne.creerLigne(p, c);
            System.out.println("LIGNE"+lc);
           // liste.add(lc);
            
            
            
           // session.setAttribute("liste", liste);
            
         
            
            
          url="client.jsp";
            //Commande c = (Commande) session.getAttribute("commande");// La commande n'est PAS LA
           //méthode pour ajouter
            
            
            
           // liste.add(); une fois la ligne finie
        }
// Fin nouvelle fonction CHRIS

        if ("val".equalsIgnoreCase(action)) {

            List<LigneCommande> listeCom = (List<LigneCommande>) session.getAttribute("liste");

            beanCommande.triCuisine(listeCom, listeCuisine);
            Commande c = (Commande) session.getAttribute("Commande");
            beanCommande.persist(c);
            application.setAttribute("listeCuisine", listeCuisine);
        }

        if ("su".equalsIgnoreCase(action)) {
            String li = request.getParameter("ligne");
            List<LigneCommande> listee = (List<LigneCommande>) session.getAttribute("liste");
            System.out.println("La liste:" + listee);
            for (LigneCommande lc : listee) {
                if (Objects.equals(lc.getId(), Long.valueOf(li))) {
                    LigneCommande lcc = beanLigne.sortirLigne(lc, li);
                    session.setAttribute("lcc", lcc);
                }
            }
            LigneCommande lcc = (LigneCommande) session.getAttribute("lcc");
            listee.remove(lcc);
            session.setAttribute("liste", listee);
            
            url = "client.jsp";
        }

        if ("produits".equalsIgnoreCase(action)) {
            if (!beanMenu.isJeuxCree()) {
                beanMenu.creerJeuxDonnees();
            }
            url = "home.jsp";
        }
        if ("mo".equalsIgnoreCase(action)) {
            System.out.println("moooo ok");
//           String id = request.getParameter("id");
//            String ligne = request.getParameter("ligne");
//            System.out.println(id+"   "+ligne+"------------------------>>>>>>>>>>>>>>>>>>>>>>>>>>>$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
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
