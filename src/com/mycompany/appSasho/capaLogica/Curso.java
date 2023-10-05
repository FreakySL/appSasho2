/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appSasho.capaLogica;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author santi
 */
public class Curso {
    
    private int codCurso;
    private String nombre;
    private int cantModulos;
    private int cantJornadas;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private List<Horario> horarios;

    public Curso(int codCurso, String nombre, int cantModulos, int cantJornadas, LocalDate fechaInicio, LocalDate fechaFin, List<Horario> horarios) {
        this.codCurso = codCurso;
        this.nombre = nombre;
        this.cantModulos = cantModulos;
        this.cantJornadas = cantJornadas;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.horarios = horarios;
    }

    public int getCodCurso() {
        return codCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantModulos() {
        return cantModulos;
    }

    public int getCantJornadas() {
        return cantJornadas;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setCodCurso(int codCurso) {
        this.codCurso = codCurso;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantModulos(int cantModulos) {
        this.cantModulos = cantModulos;
    }

    public void setCantJornadas(int cantJornadas) {
        this.cantJornadas = cantJornadas;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }
    
    
}
