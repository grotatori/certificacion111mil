package centrocultural.model;

import java.util.Date;

/**
 *
 * @author giselaRotatori
 */
public class Participante extends Persona {
    private Date fechaNac;
    private int cantCursosAnotado;
    private String padreTutor;

    //Constructores
    public Participante(){}
    
    public Participante(String apellido, String nombre, long telefono, String email, Date fechaNac) {
        super(apellido, nombre, telefono, email);
        this.fechaNac = fechaNac;
        this.cantCursosAnotado = 0;
    }

    public Participante(Date fechaNac, int cantCursosAnotado, String padreTutor, String apellido, String nombre, long telefono, String email) {
        super(apellido, nombre, telefono, email);
        this.fechaNac = fechaNac;
        this.cantCursosAnotado = cantCursosAnotado;
        this.padreTutor = padreTutor;
    }
    
    public Participante(int id, String apellido, String nombre, long telefono, String email, Date fechaNac, int cantCursosAnotado) {
        super(id, apellido, nombre, telefono, email);
        this.fechaNac = fechaNac;
        this.cantCursosAnotado = cantCursosAnotado;
    }


    //getters/setters
    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public int getCantCursosAnotado() {
        return cantCursosAnotado;
    }

    public void setCantCursosAnotado(int cantCursosAnotado) {
        this.cantCursosAnotado = cantCursosAnotado;
    }

    public String getPadreTutor() {
        return padreTutor;
    }

    public void setPadreTutor(String padreTutor) {
        this.padreTutor = padreTutor;
    }

    //Metodos
    @Override
    public String toString() {
        return "Participante{" + "fechaNac=" + fechaNac + super.toString();
    }
}
