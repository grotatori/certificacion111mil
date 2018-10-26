package centrocultural.controller;

import centrocultural.dao.CursosDAOHibernate;
import centrocultural.dao.ICursosDAO;
import centrocultural.excepciones.ExistException;
import centrocultural.model.Curso;
import centrocultural.model.Profesor;
import centrocultural.model.Tematica;
import java.util.List;

/**
 *
 * @author giselaRotatori
 */
public class GestionCursos {
    private final ICursosDAO cursoDAO = new CursosDAOHibernate();
    
    public void nuevoCurso(String nombre, Profesor profesor, int cuposDisponibles, Tematica tematica, int duracion, int cargaHoraria, int aula){
        try{
            Curso curso = new Curso(nombre, profesor, cuposDisponibles, duracion, cargaHoraria, tematica, aula);
            cursoDAO.addCurso(curso);
        }catch(ExistException e){
            System.out.println(e.getMessage());
        }
    }
    
    public List<Curso> getAllCursos(){
        return cursoDAO.getAllCursos();
    }
    
    public Curso getCursoById(int id){
        return cursoDAO.searchCurso(id);
    }
    
    public List<Curso> getCursosByTematica(String tematica){
        return cursoDAO.getAllCursosByTematica(tematica);
    }
}
