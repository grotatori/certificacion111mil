package centrocultural.controller;

import centrocultural.dao.IProfesorDAO;
import centrocultural.dao.ProfesorDAOHibernate;
import centrocultural.model.Profesor;

/**
 *
 * @author giselaRotatori
 */
public class GestionProfesores {
    private final IProfesorDAO profesorDAO = new ProfesorDAOHibernate();
    
    public void addProfesor(String apellido, String nombre, long telefono, String email, float sueldo){
        Profesor prof = new Profesor(apellido, nombre, telefono, email, sueldo);
        profesorDAO.addProfesor(prof);
    }
    
    public Profesor getProfesorById(int id){
        return profesorDAO.getProfesorById(id);
    }
    
}
