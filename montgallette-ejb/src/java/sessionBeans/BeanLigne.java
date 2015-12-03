/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cdi404
 */
@Stateful
public class BeanLigne implements BeanLigneLocal {
    
    
  @PersistenceContext(unitName = "montgallette-ejbPU")
    private EntityManager em;
  
    public void ajouterLigne() {

    }

    public void consulterEtat() {

    }

    public void changerEtat() {

    }

}
