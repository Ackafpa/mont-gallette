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
import sessionBeans.BeanTestDataLocal;

public class TestData implements ControllerInterface, Serializable {

    BeanTestDataLocal beanTestData = lookupBeanTestDataLocal();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, HttpServlet servlet) {
        beanTestData.generateEmployees();
        return "home.jsp";
    }

    private BeanTestDataLocal lookupBeanTestDataLocal() {
        try {
            Context c = new InitialContext();
            return (BeanTestDataLocal) c.lookup("java:global/montgallette/montgallette-ejb/BeanTestData!sessionBeans.BeanTestDataLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
