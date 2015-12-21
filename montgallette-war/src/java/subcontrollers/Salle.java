package subcontrollers;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sessionBeans.BeanEmplacementLocal;
import sessionBeans.BeanTableeLocal;

public class Salle implements ControllerInterface, Serializable{
    BeanEmplacementLocal beanEmplacement = lookupBeanEmplacementLocal();

    BeanTableeLocal beanTablee = lookupBeanTableeLocal();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, HttpServlet servlet) {
        String url = "home.jsp";
        String action = request.getParameter("action");
        ServletContext application = servlet.getServletContext();
        
        if("jeuTables".equalsIgnoreCase(action)){
            beanTablee.jeuTables();
            url="home.jsp";
        }
        
        if("jeuEmplacements".equalsIgnoreCase(action)){
            application.setAttribute("HMemp", beanEmplacement.creerJeu());
            
            application.setAttribute("lemp", beanEmplacement.getListeEmplacement());
            url="home.jsp";
        }  
        return url;
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
