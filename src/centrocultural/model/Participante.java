/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centrocultural.model;

import java.util.Date;

/**
 *
 * @author giselaRotatori
 */
public class Participante extends Persona {
    private Date fechaNac;

    //Constructores
    public Participante(String apellido, String nombre, int telefono, String email, Date fechaNac) {
        super(apellido, nombre, telefono, email);
        this.fechaNac = fechaNac;
    }

    //getters/setters
    public Participante(Date fechaNac, int id, String apellido, String nombre, int telefono, String email) {
        super(id, apellido, nombre, telefono, email);
        this.fechaNac = fechaNac;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }
    
    
    
    
}
