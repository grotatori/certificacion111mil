package centrocultural.model;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author giselaRotatori
 */
public class Inscripcion {
    private int id;
    private Curso curso;
    private Participante inscripto;
    private Condicion condicion;
    private Date fechaInscripcion;
    
    //Constructores
    public Inscripcion(){}

    public Inscripcion(Curso curso, Participante inscripto, Condicion condicion) {
        this.curso = curso;
        this.inscripto = inscripto;
        this.condicion = condicion;
        this.fechaInscripcion = Calendar.getInstance().getTime();
    }

    public Inscripcion(int id, Curso curso, Participante inscripto, Condicion condicion) {
        this(curso, inscripto, condicion);
        this.id = id;
    }

    //getters/setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Participante getInscripto() {
        return inscripto;
    }

    public void setInscripto(Participante inscripto) {
        this.inscripto = inscripto;
    }

    public Condicion getCondicion() {
        return condicion;
    }

    public void setCondicion(Condicion condicion) {
        this.condicion = condicion;
    }
    
    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }
    
    
    //Metodos
    @Override
    public String toString() {
        System.out.println("");;
        return "Inscripcion{" + "id=" + id + ", curso=" + curso + ", inscripto=" + inscripto + ", condicion=" + condicion + ", fechaInscripcion=" + '}';
    }
    
    
    
}
