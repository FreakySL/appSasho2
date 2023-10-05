/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appSasho.capaLogica;

/**
 *
 * @author santi
 */
public class Profesor extends Persona {
    
    private String profesion;

    public Profesor(String profesion, int codPersona, String nombre, String apellido, int edad, String domicilio, int telefono) {
        super(codPersona, nombre, apellido, edad, domicilio, telefono);
        this.profesion = profesion;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }
    
}
