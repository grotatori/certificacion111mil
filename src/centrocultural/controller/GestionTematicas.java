package centrocultural.controller;

import centrocultural.dao.ITematicaDAO;
import centrocultural.dao.TematicaDAOHibernate;
import centrocultural.model.Tematica;
import java.util.List;
/**
 *
 * @author giselaRotatori
 */
public class GestionTematicas {
    private final ITematicaDAO tematicaDAO = new TematicaDAOHibernate();
    
    public void agregarTematica(String nombre){
        Tematica tem = new Tematica(nombre);
        tematicaDAO.addTematica(tem);
    }
    
    public List<Tematica> traerTematicas(){
        return tematicaDAO.getAllTematicas();
    }
    
    public Tematica getTematicaByName(String nombre){
        return tematicaDAO.searchTematica(nombre);
    }
}
