/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centrocultural.dao;

import centrocultural.model.Condicion;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import resources.HibernateUtil;

/**
 *
 * @author zapph
 */
public class CondicionHardCore {
    private Session sesion;
    private Transaction tx;
    
    private void iniciaOperacion() throws HibernateException{
        sesion = HibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
    }
    
    public void addCondicion(){
        iniciaOperacion();
        Condicion cond = new Condicion("Efectivo");
        sesion.save(cond);
        tx.commit();
        sesion.close();
        
        iniciaOperacion();
        cond = new Condicion("Condicional");
        sesion.save(cond);
        tx.commit();
        sesion.close();
    }
}
