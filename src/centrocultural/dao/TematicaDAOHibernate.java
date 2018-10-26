package centrocultural.dao;

import centrocultural.model.Tematica;
import java.util.List;
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
public class TematicaDAOHibernate implements ITematicaDAO{
    private Session sesion;
    private Transaction tx;
    
    private void iniciaOperacion() throws HibernateException{
        sesion = HibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
    }
    
    private void manejadorExcepcion(HibernateException he) throws HibernateException{
        tx.rollback();
        throw new HibernateException("Ocurrio un error en la capa de acceso a datos", he);
    }
    
    @Override
    public Tematica searchTematica(String nombre) {
        Tematica tem = null;
        try{
            iniciaOperacion();
            CriteriaBuilder builder = sesion.getCriteriaBuilder();
            CriteriaQuery<Tematica> qry = builder.createQuery(Tematica.class);
            Root<Tematica> root = qry.from(Tematica.class);
            qry.select(root);
            qry.where(builder.equal(root.get("nombre"), nombre));
            
            tem = sesion.createQuery(qry).uniqueResult();
        }catch(HibernateException he){
            manejadorExcepcion(he);
            throw he;
        }finally{
            sesion.close();
        }
        return tem;
    }

    @Override
    public List<Tematica> getAllTematicas() {
        List<Tematica> lista = null;
        try{
            iniciaOperacion();
            CriteriaBuilder builder = sesion.getCriteriaBuilder();
            CriteriaQuery<Tematica> qry = builder.createQuery(Tematica.class);
            Root<Tematica> root = qry.from(Tematica.class);
            qry.select(root);
            
            lista = sesion.createQuery(qry).list();
        }finally{
            sesion.close();
        }
        return lista;
    }

    @Override
    public void addTematica(Tematica tematica) {
        try{
            iniciaOperacion();
            sesion.save(tematica);
            tx.commit();
        }catch(HibernateException he){
            manejadorExcepcion(he);
            throw he;
        }finally{
            sesion.close();
        }
    }
    
}
