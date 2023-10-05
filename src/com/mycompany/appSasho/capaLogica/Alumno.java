/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appSasho.capaLogica;

/**
 *
 * @author santi
 */
public class Alumno extends Persona{
    
    private String email;

    public Alumno(String email, int codPersona, String nombre, String apellido, int edad, String domicilio, int telefono) {
        super(codPersona, nombre, apellido, edad, domicilio, telefono);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
