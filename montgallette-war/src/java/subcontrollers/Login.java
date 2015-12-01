package subcontrollers;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sessionBeans.BeanLoginLocal;

/**
 *
 * @author cdi406
 */
public class Login implements ControllerInterface, Serializable{
    BeanLoginLocal beanLogin = lookupBeanLoginLocal();

    
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, HttpServlet servlet) {
        String url = "login.jsp";
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        
        if("login".equalsIgnoreCase(action)){
            String code = request.getParameter("id");
            
            if(session.getAttribute("user") == null){
                session.setAttribute("user", beanLogin.identifierEmploye(code));
            }
            
            url = "garcon.jsp";
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
