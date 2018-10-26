package centrocultural.dao;

import centrocultural.model.Profesor;
/**
 *
 * @author giselaRotatori
 */
public interface IProfesorDAO {
    void addProfesor(Profesor prof);
    Profesor searchProfesor(String email);
    Profesor getProfesorById(int id);
}
