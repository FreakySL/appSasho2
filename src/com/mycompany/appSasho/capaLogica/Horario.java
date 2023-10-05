/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appSasho.capaLogica;

import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author santi
 */
public class Horario {
    
    private String codHorario;
    private Date fecha;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    public Horario(String codHorario,Date fecha, LocalTime horaInicio, LocalTime horaFin) {
        this.codHorario = codHorario;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public String getCodHorario() {
        return codHorario;
    }
    
    public Date getFecha() {
        return fecha;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setCodHorario(String codHorario) {
        this.codHorario = codHorario;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    } 
    
}
