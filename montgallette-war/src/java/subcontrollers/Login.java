package subcontrollers;

import entites.Employe;
import java.io.Serializable;
import java.util.HashMap;
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
import outils.CustomException;
import sessionBeans.BeanLoginLocal;

/**
 *
 * @author cdi406
 */
public class Login implements ControllerInterface, Serializable {

    BeanLoginLocal beanLogin = lookupBeanLoginLocal();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, HttpServlet servlet) {
        String url = "home.jsp";
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        ServletContext application = servlet.getServletContext();

        /*
         <c:url value="images/Table4persDispo.png" var="t4d"/>
         <c:url value="images/table2persVertiDispo.png" var="t2vd"/>
         <c:url value="images/table2persHorizDispo.png" var="t2hd"/>
         <c:url value="images/Table4persIndispo.png" var="t4i"/>
         <c:url value="images/table2persVertiIndispo.png" var="t2vi"/>
         <c:url value="images/table2persHorizIndispo.png" var="t2hi"/>
         */



        //Connexion à l'interface
        if ("login".equalsIgnoreCase(action)) {

            String code = request.getParameter("id");

            if (session.getAttribute("user") != null) {

                //Si le nouveau code entré ne vient pas du mode client
                if (session.getAttribute("prov") == null) {
                    String eCode = beanLogin.recupEmploye(session.getAttribute("user")).getCode();

                    if (code.equals(eCode) && code.startsWith("1")) {

                        url = "garcon.jsp";

                    } else if (code.equals(eCode) && code.startsWith("2")) {
                        url = "cuisine.jsp";

                    } else {
                        //accès à la possibilité de deconnexion
                        boolean deco = true;
                        request.setAttribute("msgDeco", "Vous n'êtes pas ");
                        request.setAttribute("deco", deco);
                    }
                } else {
                    //Si le code vient du mode client : pas de déco possible, seulement rentrer le code exact du garçon
                    String eCode = beanLogin.recupEmploye(session.getAttribute("user")).getCode();
                    if (code.equals(eCode)) {
                        session.removeAttribute("prov");
                        url = "garcon.jsp";
                    }
                }
            } else {

                //Verif de la longueur du code entré
                if (code.length() == 4) {

                    //Reconnaissance de la catégorie d'employé et envoi vers la bonne interface
                    if (session.getAttribute("user") == null) {
                        try {
                            Employe e = beanLogin.identifierEmploye(code);

                            if (code.startsWith("1")) {
                                url = "garcon.jsp";
                                session.setAttribute("user", e);
                            } else if (code.startsWith("2")) {
                                url = "cuisine.jsp";
                                session.setAttribute("user", e);
                            }

                        } catch (CustomException ex) {

                            HashMap<String, String> mp = ex.getErreurs();
                            request.setAttribute("msgErr", ex.getMessage());
                            for (String clef : mp.keySet()) {
                                request.setAttribute(clef, mp.get(clef));
                            }
                            url = "home.jsp";
                        }

                    }
                } else {
                    request.setAttribute("msg", "Code invalide");
                    url = "home.jsp";
                }
            }
        }

        if ("client".equalsIgnoreCase(action)) {
            session.setAttribute("prov", "client");
            request.setAttribute("idGarcon", beanLogin.recupEmploye(session.getAttribute("user")).getId());

            url = "client.jsp";
        }

        //Création d'un jeu d'essai
        if ("test".equalsIgnoreCase(action)) {
            beanLogin.creerJeuTest();
            request.setAttribute("msg", "Jeu d'essai crée!");
            url = "home.jsp";
        }

        //Déconnexion
        if ("deco".equalsIgnoreCase(action)) {
            session.removeAttribute("user");
            url = "home.jsp";
        }

        return url;
    }

    private BeanLoginLocal lookupBeanLoginLocal() {
        try {
            Context c = new InitialContext();
            return (BeanLoginLocal) c.lookup("java:global/montgallette/montgallette-ejb/BeanLogin!sessionBeans.BeanLoginLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
