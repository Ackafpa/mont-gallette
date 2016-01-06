
package sessionBeans;

import entites.Employe;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class BeanTestData implements BeanTestDataLocal {
    @PersistenceContext(unitName = "montgallette-ejbPU")
    private EntityManager em;

    @Override
    public void generateEmployees() {
        List<Employe> emp = new ArrayList();
        emp.add(new Employe("Harrington", "Honor", "adresse011", "12354", "Harrington Steading", "1234"));
        emp.add(new Employe("Alexander", "Hamish", "adresse087", "1654", "White Haven", "5698"));
        emp.add(new Employe("Alexander", "Emily", "adresse087", "1654", "White Haven", "5698"));
        emp.add(new Employe("Blues", "Jake", "adresse023", "25654", "Chicago", "2587"));
        emp.add(new Employe("Blues", "Elwood", "adresse089", "25654", "Chicago", "2589"));
        emp.stream().forEach((e) -> {em.persist(e);});
    }
}
