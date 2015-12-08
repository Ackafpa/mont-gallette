/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subcontrollers;

import entites.LigneCommande;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sessionBeans.BeanCommande;
import sessionBeans.BeanCommandeLocal;

/**
 *
 * @author cdi404
 */
public class OngletCommande implements ControllerInterface{
    BeanCommande beanCommande1 = lookupBeanCommandeBean();
    BeanCommandeLocal beanCommande = lookupBeanCommandeLocal();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, HttpServlet servlet) {
        String url = "commande.jsp";
        HttpSession session = request.getSession();
       String msg = "Votre commande est vide";
       String action = request.getParameter("action");
      
        
        
        if ("ajouter".equalsIgnoreCase("action")){
           String id = request.getParameter("id");
            
            
           
        }
        if ("supprimer".equalsIgnoreCase("action")){
            request.getParameter("id");
            request.getParameter("ligne");
            
           
            
            
            beanCommande1.supprimerLigne(null,null);
            
 
         
        }
         if ("modifier".equalsIgnoreCase("action")){
             LigneCommande ligne = new LigneCommande();
//récupérer la ligne     

 
         
        }
        
        
        
        
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

    private BeanCommande lookupBeanCommandeBean() {
        try {
            Context c = new InitialContext();
            return (BeanCommande) c.lookup("java:global/montgallette/montgallette-war/BeanCommande!sessionBeans.BeanCommande");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    


    
    
}
