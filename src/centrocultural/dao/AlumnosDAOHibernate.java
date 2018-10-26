package centrocultural.dao;

import centrocultural.excepciones.ExistException;
import centrocultural.model.Participante;
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
public class AlumnosDAOHibernate implements IAlumnosDAO{
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
    public void addAlumno(Participante participante) throws ExistException{
        try{
            if(searchAlumno(participante.getEmail()) == null){
                iniciaOperacion();
                sesion.save(participante);
                tx.commit();
            }else{
                throw new ExistException("El participante ya existe");
            }
        }catch (HibernateException he){
            manejadorExcepcion(he);
            throw he;
        }finally{
            sesion.close();
        }
    }

    @Override
    public Participante searchAlumno(String email) {
        Participante par = null;
        try{
            iniciaOperacion();
            CriteriaBuilder builder = sesion.getCriteriaBuilder();
            CriteriaQuery<Participante> qry = builder.createQuery(Participante.class);
            Root<Participante> root = qry.from(Participante.class);
            qry.select(root);
            qry.where(builder.equal(root.get("email"), email));
            
            par = sesion.createQuery(qry).uniqueResult();
        }catch (HibernateException he){
            manejadorExcepcion(he);
            throw he;
        }finally{
            sesion.close();
        }
        return par;
    }

    @Override
    public void updateAlumo(Participante participante) {
        try{
            iniciaOperacion();
            sesion.update(participante);
            tx.commit();
        }catch(HibernateException he){
            manejadorExcepcion(he);
            throw he;
        }finally{
            sesion.close();
        }
    }
    
}
