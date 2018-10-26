package centrocultural.dao;

import centrocultural.model.Profesor;
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
public class ProfesorDAOHibernate implements IProfesorDAO{
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
    public void addProfesor(Profesor prof) {
        try{
            iniciaOperacion();
            sesion.save(prof);
            tx.commit();
        }catch(HibernateException he){
            manejadorExcepcion(he);
            throw he;
        }finally{
            sesion.close();
        }
    }

    @Override
    public Profesor searchProfesor(String email) {
        Profesor prof = null;
        try{
            iniciaOperacion();
            CriteriaBuilder builder = sesion.getCriteriaBuilder();
            CriteriaQuery<Profesor> qry = builder.createQuery(Profesor.class);
            Root<Profesor> root = qry.from(Profesor.class);
            qry.select(root);
            qry.where(builder.equal(root.get("email"), email));
            
            prof = sesion.createQuery(qry).uniqueResult();
        }catch (HibernateException he){
            manejadorExcepcion(he);
            throw he;
        }finally{
            sesion.close();
        }
        return prof;
    }
    
    @Override
    public Profesor getProfesorById(int id){
        Profesor prof = null;
        try{
            iniciaOperacion();
            prof = (Profesor)sesion.get(Profesor.class, id);
        }catch(HibernateException he){
            manejadorExcepcion(he);
            throw he;
        }finally{
            sesion.close();
        }
        return prof;
    }
}
