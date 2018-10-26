package centrocultural.dao;

import centrocultural.excepciones.ExistException;
import centrocultural.model.Curso;
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
public class CursosDAOHibernate implements ICursosDAO{
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
    
    //Metodos implementados Interface
    @Override
    public void addCurso(Curso curso) throws ExistException {
        try{     
            if(searchCurso(curso.getId()) == null){
                iniciaOperacion();
                sesion.save(curso);
                tx.commit();
            }else{
                throw new ExistException("El curso ya existe");
            }
        }catch(HibernateException he){
            manejadorExcepcion(he);
            throw he;
        }finally{
            sesion.close();
        }
    }

    @Override
    public List<Curso> getAllCursosByTematica(String tematica) {
        List<Curso> lista = null;
        ITematicaDAO tematicaDAO = new TematicaDAOHibernate();
        Tematica aux = tematicaDAO.searchTematica(tematica);
        try{
            iniciaOperacion();
            CriteriaBuilder builder = sesion.getCriteriaBuilder();
            CriteriaQuery<Curso> qry = builder.createQuery(Curso.class);
            Root<Curso> root = qry.from(Curso.class);
            qry.select(root);
            qry.where(builder.equal(root.get("tematica"), aux.getId()));
            
            lista = sesion.createQuery(qry).list();
        }catch(HibernateException he){
            manejadorExcepcion(he);
            throw he;
        }finally{
            sesion.close();
        }
        return lista;
    }

    @Override
    public List<Curso> getAllCursos() {
        List<Curso> lista = null;
        try{
            iniciaOperacion();
            CriteriaBuilder builder = sesion.getCriteriaBuilder();
            CriteriaQuery<Curso> qry = builder.createQuery(Curso.class);
            Root<Curso> root = qry.from(Curso.class);
            qry.select(root);
            
            lista = sesion.createQuery(qry).list();
        }catch(HibernateException he){
            manejadorExcepcion(he);
            throw he;
        }finally{
            sesion.close();
        }
        return lista;
    }

    @Override
    public Curso searchCurso(int id) {
        Curso curso = null;
        try{
            iniciaOperacion();
            curso = (Curso) sesion.get(Curso.class, id);
        }catch(HibernateException he){
            manejadorExcepcion(he);
            throw he;
        }finally{
            sesion.close();
        }
        return curso;
    }

    @Override
    public void updateCurso(Curso curso) {
        try{
            iniciaOperacion();
            sesion.update(curso);
            tx.commit();
        }catch(HibernateException he){
            manejadorExcepcion(he);
            throw he;
        }finally{
            sesion.close();
        }
    }

    
    
}
