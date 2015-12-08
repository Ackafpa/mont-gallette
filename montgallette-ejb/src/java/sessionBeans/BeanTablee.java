package sessionBeans;

import entites.Commande;
import entites.Tablee;
import javax.ejb.Stateful;

@Stateful
public class BeanTablee implements BeanTableeLocal {

    public void appelerGarcon() {
        //Envoyer alerte au serveur
    }

    public void modifCouverts(Tablee t, int n) {
        t.setCouverts(n);
    }

    public double addition(Tablee t) {
        double somme = 0;

        for (Commande c : t.getCommandes()) {
            //A FINALISER / VERIFIER AVEC CLASSE COMMANDE
            // somme += t.getCommandes().getMontantCommande();
        }
        return somme;
    }

}
