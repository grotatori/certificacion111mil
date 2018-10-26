package centrocultural.dao;

import centrocultural.model.Tematica;
import java.util.List;

/**
 *
 * @author giselaRotatori
 */
public interface ITematicaDAO {
    Tematica searchTematica(String nombre);
    List<Tematica> getAllTematicas();
    void addTematica(Tematica tematica);
    
}
