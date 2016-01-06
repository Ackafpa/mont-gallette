package controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import subcontrollers.ControllerInterface;

/**
 *
 * @author cdi406
 */
public class Controller extends HttpServlet {

    private HashMap<String, ControllerInterface> subcont;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config); 
        subcont = new HashMap();
        for(Enumeration<String> e = config.getInitParameterNames(); e.hasMoreElements(); ){
            String nom = e.nextElement();
            String classe = config.getInitParameter(nom);
            try{
                ControllerInterface ctrl = (ControllerInterface) Class.forName(classe).newInstance();
                subcont.put(nom, ctrl);
            }   
            catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            }
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String section = request.getParameter("section");
        String prefixe = "/WEB-INF/jsp/";
        String url = "home.jsp";
        
        if(section != null && section.endsWith(".acka")){
            ControllerInterface ctrl = subcont.get(section);
            url = ctrl.execute(request, response, this);
        }
        
        url = response.encodeURL(prefixe + url);
        getServletContext().getRequestDispatcher(url).include(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
