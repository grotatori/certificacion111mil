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
public class Persona {
    private int id;
    private String apellido;
    private String nombre;
    private int telefono;
    private String email;
    
    //Constructores
    public Persona(String apellido, String nombre, int telefono, String email){
        this.apellido = apellido;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }
    
    //getters/setters
    public Persona(int id, String apellido, String nombre, int telefono, String email){
        this(apellido, nombre, telefono, email);
        this.id = id;
    }

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

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
