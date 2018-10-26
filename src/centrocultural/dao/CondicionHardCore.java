package centrocultural.dao;

import centrocultural.model.Condicion;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import resources.HibernateUtil;

/**
 *
 * @author giselaRotatori
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
