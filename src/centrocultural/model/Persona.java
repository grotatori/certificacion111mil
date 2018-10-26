package centrocultural.model;

/**
 *
 * @author giselaRotatori
 */
public abstract class Persona {
    protected int id;
    protected String apellido;
    protected String nombre;
    protected long telefono;
    protected String email;

    //Constructores
    public Persona(){}
    public Persona(String apellido, String nombre, long telefono, String email) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    public Persona(int id, String apellido, String nombre, long telefono, String email) {
        this(apellido, nombre, telefono, email);
        this.id = id;
    }

    //getters/setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //Metodos
    @Override
    public String toString() {
        return "{" + "id=" + id + ", apellido=" + apellido + ", nombre=" + nombre + ", telefono=" + telefono + ", email=" + email + '}';
    }
}
