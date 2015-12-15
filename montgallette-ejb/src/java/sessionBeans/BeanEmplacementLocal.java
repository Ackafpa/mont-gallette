/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import entites.Emplacement;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author CDI417
 */
@Local
public interface BeanEmplacementLocal {

    public void creerJeu();

    public Emplacement recupEmplacement(String numero);

    public Collection<Emplacement> collEmplacement(String numero);
    
}
