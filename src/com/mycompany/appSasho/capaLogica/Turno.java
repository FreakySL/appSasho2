/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appSasho.capaLogica;

/**
 *
 * @author santi
 */
public class Turno {
    
    private int codTurno;
    private int tipoServicio;
    private float costo;
    Horario horario;

    public Turno(int codTurno, int tipoServicio, float costo, Horario horario) {
        this.codTurno = codTurno;
        this.tipoServicio = tipoServicio;
        this.costo = costo;
        this.horario = horario;
    }

    public int getCodTurno() {
        return codTurno;
    }

    public int getTipoServicio() {
        return tipoServicio;
    }

    public float getCosto() {
        return costo;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setCodTurno(int codTurno) {
        this.codTurno = codTurno;
    }
    
    public void setTipoServicio(int tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }
   
    
    
}
