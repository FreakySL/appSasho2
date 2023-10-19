/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appSasho.capaLogica;

import com.mycompany.appSasho.capaDatos.TurnoDAOImpPostgres;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author santi
 */
public class TurnoManager {
    
    private static final TurnoDAOImpPostgres turnoDAO = new TurnoDAOImpPostgres();
    
    public void agregarTurno(int tipoServicio, float costo, int codCliente, Date diaTurno, LocalTime horaInicioTurno, LocalTime horaFinTurno) throws SQLException{
        
        String codHorario = HorarioManager.agregarHorario(diaTurno, horaInicioTurno, horaFinTurno);
        
        String codTurno = calcularCodigoTurno();
        
        Turno turno = new Turno(codTurno, tipoServicio, costo, codCliente, codHorario);
        
        turnoDAO.create(turno);
        
    }
    
    private static String calcularCodigoTurno() throws SQLException{
        String ultimoCodigo = TurnoDAOImpPostgres.obtenerUltimoCodigoTurnos();
        int aux;
        String codigo;       
        
        if (ultimoCodigo == null){
            codigo = "TUR00001";
        } else {
            aux = Integer.parseInt(""+ultimoCodigo.charAt(3)+ultimoCodigo.charAt(4)+ultimoCodigo.charAt(5)+ultimoCodigo.charAt(6)+ultimoCodigo.charAt(7));
            aux += 1;
            if (aux < 10){
                codigo = "TUR0000"+aux;
            } else if (aux < 100){
                codigo = "TUR000"+aux;
            } else if (aux < 1000){
                codigo = "TUR00"+aux;
            } else if (aux < 10000){
                codigo = "TUR0"+aux;
            } else {
                codigo = "TUR"+aux;
            }
        }
        
        return codigo;
        
    }
    
    
}
