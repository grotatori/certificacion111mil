package centrocultural.model;

/**
 *
 * @author giselaRotatori
 */
public class Tematica {
    private int id;
    private String nombre;
    
    //Constructores
    public Tematica() {}
    public Tematica(String nombre) {
        this.nombre = nombre;
    }

    public Tematica(int id, String nombre) {
        this(nombre);
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

    @Override
    public String toString() {
        return "Tematica{" + "id=" + id + ", nombre=" + nombre + '}';
    }
}
