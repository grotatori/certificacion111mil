package centrocultural.dao;

import centrocultural.excepciones.ExistException;
import centrocultural.model.Participante;

/**
 *
 * @author giselaRotatori
 */
public interface IAlumnosDAO {
    void addAlumno(Participante participante) throws ExistException;
    Participante searchAlumno(String email);
    void updateAlumo(Participante participante);
}
