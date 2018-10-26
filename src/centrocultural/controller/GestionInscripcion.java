package centrocultural.controller;

import centrocultural.dao.AlumnosDAOHibernate;
import centrocultural.dao.CondicionDAOHibernate;
import centrocultural.dao.CursosDAOHibernate;
import centrocultural.dao.IAlumnosDAO;
import centrocultural.dao.ICursosDAO;
import centrocultural.dao.IInscripcionDAO;
import centrocultural.dao.InscripcionDAOHibernate;
import centrocultural.excepciones.ExistException;
import centrocultural.model.Condicion;
import centrocultural.model.Curso;
import centrocultural.model.Inscripcion;
import centrocultural.model.Participante;

/**
 *
 * @author giselaRotatori
 */
public class GestionInscripcion {
    private final IInscripcionDAO inscripcionDAO = new InscripcionDAOHibernate();
    private final IAlumnosDAO alumnoDAO = new AlumnosDAOHibernate();
    private final ICursosDAO cursoDAO = new CursosDAOHibernate();
    private final CondicionDAOHibernate condicionDAO = new CondicionDAOHibernate();
    
    public int nuevaInscripcion(Curso curso, Participante participante) throws ExistException{
        Condicion cond = null;
        int inscripcionCondicion = 1; //hay cupo y se inscribe normal
        if(participante.getCantCursosAnotado() < 3){
            if(curso.getCuposDisponibles() > 0){
                cond = condicionDAO.getCondicionByName("Efectivo");
                curso.setCuposDisponibles(curso.getCuposDisponibles()-1);
            }
            else{
                cond = condicionDAO.getCondicionByName("Condicional");
                inscripcionCondicion = 0; //Se inscribe como condicional
            }
            participante.setCantCursosAnotado(participante.getCantCursosAnotado()+1);
            Inscripcion nuevaInsc = new Inscripcion(curso, participante, cond);
            alumnoDAO.updateAlumo(participante);
            cursoDAO.updateCurso(curso);
            inscripcionDAO.addInscripcion(nuevaInsc);
        }else{
            throw new ExistException("Llego al máximo de cursos anotados, no se puede inscribir a mas");
        }
        return inscripcionCondicion;
    }
}
