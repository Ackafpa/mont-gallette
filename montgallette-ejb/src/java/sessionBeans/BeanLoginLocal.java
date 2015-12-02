package sessionBeans;

import entites.Employe;
import javax.ejb.Local;
import outils.CustomException;

/**
 *
 * @author cdi406
 */
@Local
public interface BeanLoginLocal {

    public Employe identifierEmploye(String code)throws CustomException;

    public Employe deconnexion(Employe e);

    public void creerJeuTest();
    
}
