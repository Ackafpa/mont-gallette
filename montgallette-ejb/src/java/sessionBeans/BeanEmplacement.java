package sessionBeans;

import entites.Emplacement;
import entites.Tablee;
import javax.ejb.Stateful;

@Stateful
public class BeanEmplacement implements BeanEmplacementLocal {

    public void modifierDispo(Emplacement e) {        
// true=dispo      false=occupee
        if (e.isDispo() == false) {
            e.setDispo(true);
        } else {
            e.setDispo(false);
        }
    }

    public void ajouterEmplacement(Tablee t, Emplacement e) {
        if (e.isDispo()) {
            t.getEmplacements().add(e);
            modifierDispo(e);
        } else {
            System.out.println("ERREUR : L'emplacement " + e + " n'est pas disponible!");
        }
    }

    public void supprimerEmplacement(Tablee t, Emplacement e) {
        if (t.getEmplacements().contains(e)) {
            t.getEmplacements().remove(e);
        } else {
            System.out.println("ERREUR : L'emplacement " + e + " n'est pas lié à la tablée");
        }
    }

}
