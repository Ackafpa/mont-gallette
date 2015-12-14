package subcontrollers;

import entites.Commande;
import entites.LigneCommande;
import entites.Tablee;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
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

        String url = "client.jsp";
        String action = request.getParameter("action");
        String msgCommande = "Cliquez sur ajouter pour remplir votre commande";
        request.setAttribute("msgCommande", msgCommande);

        if ("val".equalsIgnoreCase(action)) {
            List<LigneCommande> liste = (List<LigneCommande>) session.getAttribute("liste");
            //beanCommande= (BeanCommandeLocal) session.getAttribute("beanCommande");
            msgCommande = "Votre commande est validée";
            request.setAttribute("msgCommande", msgCommande);
            url = "client.jsp";
        }

        if ("aj".equalsIgnoreCase("action")) {

            // Attendre le bouton ajouter de Kenny
//            Commande commande = (Commande) request.getAttribute("Commande");
//            Produit produit = (Produit) request.getAttribute("Produit");
//            List <String> preferences = (List)request.getAttribute("preferences");            
            // Integer etat = 0;       
        }

        if ("creerDonnees".equalsIgnoreCase(action)) {
            List<LigneCommande> liste = beanCommande.listeLigne(beanMenu.selectAllProduit());
            request.setAttribute("liste", liste);
            session.setAttribute("liste", liste);
            beanCommande.jeuEssaiCommande(liste, beanTablee.selectTable(2L));
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>   Commande crée");
            url = "client.jsp";
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

            List<LigneCommande> liste = beanCommande.listeLigne(beanMenu.selectAllProduit());

            session.setAttribute("liste", liste);
            beanCommande.jeuEssaiCommande(liste, beanTablee.selectTable(2L));

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
}
