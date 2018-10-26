package centrocultural.dao;

import centrocultural.excepciones.ExistException;
import java.util.List;
import centrocultural.model.Curso;

/**
 *
 * @author giselaRotatori
 */
public interface ICursosDAO {
    void addCurso(Curso curso) throws ExistException;
    List<Curso> getAllCursosByTematica(String tematica);
    List<Curso> getAllCursos();
    Curso searchCurso(int id);
    void updateCurso(Curso curso);
}
