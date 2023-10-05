/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appSasho.capaLogica;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author santi
 */
public class Horario {
    
    private int codHorario;
    private LocalDate fecha;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    public Horario(int codHorario, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin) {
        this.codHorario = codHorario;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public int getCodHorario() {
        return codHorario;
    }
    
    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setCodHorario(int codHorario) {
        this.codHorario = codHorario;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    } 
    
}
