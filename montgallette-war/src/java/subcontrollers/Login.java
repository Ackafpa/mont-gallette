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
        String url = "home.jsp";
        String action = request.getParameter("action");
        HttpSession session = request.getSession();

        //Connexion à l'interface
        if ("login".equalsIgnoreCase(action)) {

            String code = request.getParameter("id");

            //Verif de la longueur du code entré
            if (code.length() == 4) {

                //Reconnaissance de la catégorie d'employé et envoi vers la bonne interface
                if (session.getAttribute("user") == null) {
                    try {
                        entites.Employe e = beanLogin.identifierEmploye(code);

                        if (code.startsWith("1")) {
                            url = "garcon.jsp";
                            session.setAttribute("user", e);
                        } else if (code.startsWith("2")) {
                            url = "cuisine.jsp";
                            session.setAttribute("user", e);
                        } else {
                            request.setAttribute("msg", "Code non reconnu");
                            url = "home.jsp";
                        }

                    } catch (CustomException ex) {

                        HashMap<String, String> mp = ex.getErreurs();
                        request.setAttribute("msgErr", ex.getMessage());
                        for (String clef : mp.keySet()) {
                            request.setAttribute(clef, mp.get(clef));
                        }
                        url = "home.jsp";
                    }

                } else {

                    String eCode = beanLogin.recupEmploye(session.getAttribute("user")).getCode();
                    if (code.equals(eCode)) {
                        if (code.startsWith("1")) {
                            url = "garcon.jsp";
                        } else if (code.startsWith("2")) {
                            url = "cuisine.jsp";
                        }

                    } else {
                        boolean deco = true;
                        request.setAttribute("msgDeco", "Vous n'êtes pas ");
                        request.setAttribute("deco", deco);
                    }
                }
            } else {
                request.setAttribute("msg", "Code invalide");
                url = "home.jsp";
            }

        }
        
        if("client".equalsIgnoreCase(action)){
            request.setAttribute("idGarcon", beanLogin.recupEmploye(session.getAttribute("user")).getId());
            
            url = "client.jsp";
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
