package centrocultural.model;

/**
 *
 * @author giselaRotatori
 */
public class Curso {
    private int id;
    private String nombre;
    private Profesor profesor;
    private int cuposDisponibles;
    private Tematica tematica;
    private int duracion; //en dias
    private int cargaHoraria; //solo horas
    private int aula;

    //Constructores
    public Curso(){}
    
    public Curso(String nombre, Profesor profesor, int cuposDisponibles, int duracion, int cargaHoraria, Tematica tematica, int aula) {
        this.nombre = nombre;
        this.profesor = profesor;
        this.cuposDisponibles = cuposDisponibles;
        this.duracion = duracion;
        this.cargaHoraria = cargaHoraria;
        this.tematica = tematica;
        this.aula = aula;
    }

    public Curso(int id, String nombre, Profesor profesor, int cuposDisponibles, int duracion, int cargaHoraria, Tematica tematica, int aula) {
        this(nombre, profesor, cuposDisponibles, duracion, cargaHoraria, tematica, aula);
        this.id = id;
    }

    //getters/setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public int getMaxInscriptos() {
        return cuposDisponibles;
    }

    public void setMaxInscriptos(int maxInscriptos) {
        this.cuposDisponibles = maxInscriptos;
    }

    public Tematica getTematica() {
        return tematica;
    }

    public void setTematica(Tematica tematica) {
        this.tematica = tematica;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public int getAula() {
        return aula;
    }

    public void setAula(int aula) {
        this.aula = aula;
    }

    public int getCuposDisponibles() {
        return cuposDisponibles;
    }

    public void setCuposDisponibles(int cuposDisponibles) {
        this.cuposDisponibles = cuposDisponibles;
    }
    
    //Metodos
    @Override
    public String toString() {
        return "Curso{" + "id=" + id + ", nombre=" + nombre + ", profesor=" + profesor + ", maxInscriptos=" + cuposDisponibles + ", duracion=" + duracion + ", cargaHoraria=" + cargaHoraria + '}';
    }

    
}
