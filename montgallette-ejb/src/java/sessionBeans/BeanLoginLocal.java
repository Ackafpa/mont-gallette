/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import entites.Employe;
import javax.ejb.Local;

/**
 *
 * @author cdi406
 */
@Local
public interface BeanLoginLocal {

    public Employe identifierEmploye(String code);

    public Employe deconnexion(Employe e);
    
}
