package centrocultural.controller;

import centrocultural.dao.AlumnosDAOHibernate;
import centrocultural.dao.CursosDAOHibernate;
import centrocultural.dao.IAlumnosDAO;
import centrocultural.dao.ICursosDAO;
import centrocultural.dao.IInscripcionDAO;
import centrocultural.dao.InscripcionDAOHibernate;
import centrocultural.model.Condicion;
import centrocultural.model.Inscripcion;
import java.util.List;

/**
 *
 * @author giselaRotatori
 */
public class GestionInscripciones {
    private final IInscripcionDAO inscripcionDAO = new InscripcionDAOHibernate();
    private final ICursosDAO cursoDAO = new CursosDAOHibernate();
    private final IAlumnosDAO alumnosDAO = new AlumnosDAOHibernate();
    
    public void addInscripcion(String email, int idCurso){
        Inscripcion inscripcion = new Inscripcion(cursoDAO.searchCurso(idCurso), alumnosDAO.searchAlumno(email), new Condicion(1,"Inscripto"));
        inscripcionDAO.addInscripcion(inscripcion);
    }
    
    public List<Inscripcion> getAllInscripcionesByCurso(int idCurso){
        return inscripcionDAO.getInscripción(idCurso);
    }
}
