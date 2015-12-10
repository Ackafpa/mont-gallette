/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import entites.Tablee;
import javax.ejb.Local;

/**
 *
 * @author CDI417
 */
@Local
public interface BeanTableeLocal {

    public void modifCouverts(Tablee t, int n);
    public double addition(Tablee t);

    public void jeuTables();

    public Tablee selectTable(Long l);
    

}
