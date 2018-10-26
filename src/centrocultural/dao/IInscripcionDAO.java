package centrocultural.dao;

import centrocultural.model.Inscripcion;
import java.util.List;

/**
 *
 * @author giselaRotatori
 */
public interface IInscripcionDAO {
    void addInscripcion(Inscripcion inscripcion);
    List<Inscripcion> getInscripción(int idCurso);
}
