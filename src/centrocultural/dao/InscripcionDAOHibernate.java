package centrocultural.dao;

import centrocultural.model.Inscripcion;
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
public class InscripcionDAOHibernate implements IInscripcionDAO{
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
    public void addInscripcion(Inscripcion inscripcion) {
        try{
            iniciaOperacion();
            sesion.save(inscripcion);
            tx.commit();
        }catch(HibernateException he){
            manejadorExcepcion(he);
            throw he;
        }finally{
            sesion.close();
        }
    }

    @Override
    public List<Inscripcion> getInscripción(int idCurso) {
        List<Inscripcion> lista = null;
        try{
            iniciaOperacion();
            CriteriaBuilder builder = sesion.getCriteriaBuilder();
            CriteriaQuery<Inscripcion> qry = builder.createQuery(Inscripcion.class);
            Root<Inscripcion> root = qry.from(Inscripcion.class);
            qry.select(root);
            
            lista = sesion.createQuery(qry).list();
            System.out.println("GEnero lista");
        }catch(HibernateException he){
            manejadorExcepcion(he);
            throw he;
        }finally{
            sesion.close();
        }
        return lista;
    }
    
}
