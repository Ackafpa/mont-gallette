package subcontrollers;

import java.io.Serializable;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
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
        String url = "login.jsp";
        String action = request.getParameter("action");
        HttpSession session = request.getSession();

        //Connexion à l'interface
        if ("login".equalsIgnoreCase(action)) {
            String code = request.getParameter("id");

            //Reconnaissance de la catégorie d'employé et envoi vers la bonne interface
            if (session.getAttribute("user") == null) {
                try {
                    if (beanLogin.identifierEmploye(code) != null) {
                        session.setAttribute("user", beanLogin.identifierEmploye(code));
                        if (code.startsWith("1")) {
                            url = "garcon.jsp";
                        } else if (code.startsWith("2")) {
                            url = "cuisine.jsp";
                        }
                    } else {
                        request.setAttribute("msg", "Code non reconnu");
                        url = "home.jsp";
                    }
                } catch (CustomException ex) {
                   HashMap<String, String> mp = ex.getErreurs();
                    request.setAttribute("msgERR", ex.getMessage());
                    for (String clef : mp.keySet()) {
                        request.setAttribute(clef, mp.get(clef));
                    }
                }
            }

        }

        //Création d'un jeu d'essai
        if ("test".equalsIgnoreCase(action)) {
            beanLogin.creerJeuTest();
            request.setAttribute("msg", "Jeu d'essai crée!");
            url = "home.jsp";
        }

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
