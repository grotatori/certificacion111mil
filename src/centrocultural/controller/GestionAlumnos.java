package centrocultural.controller;

import centrocultural.dao.AlumnosDAOHibernate;
import centrocultural.dao.IAlumnosDAO;
import centrocultural.excepciones.ExistException;
import centrocultural.model.Participante;
import java.util.Date;

/**
 *
 * @author giselaRotatori
 */
public class GestionAlumnos {
    private final IAlumnosDAO participanteDAO = new AlumnosDAOHibernate();
    
    public void nuevoParticipante(String apellido, String nombre, long telefono, String email, Date fechaNac, String padre) throws ExistException{
        Participante nuevo = new Participante(fechaNac, 0, padre, apellido, nombre, telefono, email);
        participanteDAO.addAlumno(nuevo);
    }
    
    public Participante getParticipante(String email){
        return participanteDAO.searchAlumno(email);
    }
    
    public void actualizarParticipante(Participante participante){
        participanteDAO.updateAlumo(participante);
    }
}
