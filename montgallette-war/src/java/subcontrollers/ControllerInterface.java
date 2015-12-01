package subcontrollers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cdi406
 */
public interface ControllerInterface {
    public String execute(HttpServletRequest request, HttpServletResponse response, HttpServlet servlet);
}
