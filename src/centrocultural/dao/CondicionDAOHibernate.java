package centrocultural.dao;

import centrocultural.model.Condicion;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import resources.HibernateUtil;

/**
 *
 * @author giselaRotatori
 */
public class CondicionDAOHibernate {
    private Session sesion;
    private Transaction tx;
    
    //Metodos para Hibernate
    private void iniciaOperacion() throws HibernateException{
        sesion = HibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
    }
    
    private void manejadorExcepcion(HibernateException he) throws HibernateException{
        tx.rollback();
        throw new HibernateException("Ocurrio un error en la capa de acceso a datos", he);
    }
    
    public Condicion getCondicionByName(String condicion){
        Condicion cond = null;
        try{
            iniciaOperacion();
            CriteriaBuilder builder = sesion.getCriteriaBuilder();
            CriteriaQuery<Condicion> qry = builder.createQuery(Condicion.class);
            Root<Condicion> root = qry.from(Condicion.class);
            qry.select(root);
            qry.where(builder.equal(root.get("condicion"), condicion));
            
            cond = sesion.createQuery(qry).uniqueResult();
        }catch(HibernateException he){
            manejadorExcepcion(he);
            throw he;
        }finally{
            sesion.close();
        }
        return cond;
    }
}
