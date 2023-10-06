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
    
    private String codTurno;
    private int tipoServicio;
    private float costo;
    private int codCliente;
    private String codHorario;

    public Turno(String codTurno, int tipoServicio, float costo, int codCliente, String codHorario) {
        this.codTurno = codTurno;
        this.tipoServicio = tipoServicio;
        this.costo = costo;
        this.codCliente = codCliente;
        this.codHorario = codHorario;
    }

    public String getCodTurno() {
        return codTurno;
    }

    public int getTipoServicio() {
        return tipoServicio;
    }

    public float getCosto() {
        return costo;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public String getCodHorario() {
        return codHorario;
    }

    public void setCodTurno(String codTurno) {
        this.codTurno = codTurno;
    }
    
    public void setTipoServicio(int tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public void setCodHorario(String codHorario) {
        this.codHorario = codHorario;
    }
}
