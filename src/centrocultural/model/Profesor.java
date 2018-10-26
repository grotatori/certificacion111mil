package centrocultural.model;

/**
 *
 * @author giselaRotatori
 */
public class Profesor extends Persona {
    private float sueldo;
    //Constructores
    public Profesor(){}
    public Profesor(String apellido, String nombre, long telefono, String email, float sueldo) {
        super(apellido, nombre, telefono, email);
        this.sueldo = sueldo;
    }

    public Profesor(int id, String apellido, String nombre, long telefono, String email, float sueldo) {
        super(id, apellido, nombre, telefono, email);
        this.sueldo = sueldo;
    }  

    //getters/setters
    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }

    //Metodos
    @Override
    public String toString() {
        return "Profesor" + super.toString();
    }
}
