package subcontrollers;

import entites.LigneCommande;
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
import sessionBeans.BeanTableeLocal;

public class CommandeCTRL implements ControllerInterface {
    BeanEmplacementLocal beanEmplacement = lookupBeanEmplacementLocal();

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
        String msgCommande = "Cliquez sur ajouter pour remplir votre commande";
        request.setAttribute("msgCommande", msgCommande);

        List<LigneCommande> liste = (List<LigneCommande>) application.getAttribute("listeCuisine");

        if (liste == null) {
            application.setAttribute("listeCuisine", new ArrayList());
        }
        if("creerTable".equalsIgnoreCase(action)){
            request.setAttribute("creer", true);
            url = "garcon.jsp";
        }
        
        
        if("creerCo".equalsIgnoreCase(action)){
            Integer i = Integer.decode(request.getParameter("couverts"));
            Integer j = Integer.decode(request.getParameter("table"));
            Tablee t = new Tablee();
            t.setCouverts(i);
//            Collection<Emplacement> coll = new ArrayList();
//            coll.add(beanEmplacement.recupEmplacement(j));
//            t.setEmplacements(coll);
            beanTablee.persist(t);
            
            session.setAttribute("commande", beanCommande.creerCommande(t));
            
            url="client.jsp";
        }

        if ("val".equalsIgnoreCase(action)) {

            List<LigneCommande> listeCom = (List<LigneCommande>) session.getAttribute("liste");
            beanCommande.triCuisine(listeCom, liste);

            application.setAttribute("listeCuisine", liste);
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

    private BeanEmplacementLocal lookupBeanEmplacementLocal() {
        try {
            Context c = new InitialContext();
            return (BeanEmplacementLocal) c.lookup("java:global/montgallette/montgallette-ejb/BeanEmplacement!sessionBeans.BeanEmplacementLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}

