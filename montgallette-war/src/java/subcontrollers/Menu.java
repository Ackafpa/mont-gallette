package subcontrollers;

import entites.Produit;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sessionBeans.BeanMenuLocal;

public class Menu implements ControllerInterface, Serializable {

    BeanMenuLocal beanMenu = lookupBeanMenuLocal();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, HttpServlet servlet) {

        String url = "client.jsp";
        String action = request.getParameter("action");
        String categorie = request.getParameter("categorie");

        if ("afficher".equalsIgnoreCase(action)) {
            List<Produit> lp = beanMenu.selectAllProduit(categorie);
            request.setAttribute("produits", lp);
            url = "/sub/menuCarte.jsp";
        }

        return url;
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

}
