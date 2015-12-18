/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import entites.Emplacement;
import entites.Tablee;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author CDI417
 */
@Local
public interface BeanEmplacementLocal {

    public HashMap<String,Emplacement> creerJeu();

    public Emplacement recupEmplacement(String numero);

    public Collection<Emplacement> collEmplacement(String numero);

    public List<Emplacement> getListeEmplacement();

    public void modifierDispo(HashMap<String, Emplacement> lemp, String numero);

    public void ajouterEmplacement(Tablee t, HashMap<String, Emplacement> lemp, String numero);

    public void supprimerEmplacement(Tablee t, HashMap<String, Emplacement> lemp, String numero);

   
    
}
