/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appSasho.capaLogica;

import java.time.LocalTime;
import com.mycompany.appSasho.capaDatos.HorarioDAOImpPostgres;
import java.sql.SQLException;
import java.util.Date;
import java.sql.Time;
import java.sql.PreparedStatement;
import java.util.List;

/**
 *
 * @author santi
 */
public class HorarioManager {
    
    
    private static final HorarioDAOImpPostgres horarioDAO = new HorarioDAOImpPostgres();
    

    public static void agregarHorario(Date fechaHorario, LocalTime horaInicioHorario, LocalTime horaFinHorario) throws SQLException{
        
        String codHorario = HorarioManager.calcularCodigoHorario();
        Horario horario = new Horario(codHorario, fechaHorario, horaInicioHorario, horaFinHorario);
        
        if (!seSolapa(horario)){
            
            horarioDAO.create(horario);
            // el dao recibe como parametro el objeto completo
        }
        
        
    }
    
    private static boolean seSolapa(Horario nuevoHorario) throws SQLException {
        
        List <Horario> horarios;
        
        horarios = HorarioDAOImpPostgres.obtenerHorariosPorDia(nuevoHorario.getFecha());
        
        for (Horario horarioExistente : horarios) {
            if (!nuevoHorario.getHoraFin().isBefore(horarioExistente.getHoraInicio()) &&
                !nuevoHorario.getHoraInicio().isAfter(horarioExistente.getHoraFin())) {
                return true; // Hay solapamiento
            }
        }
        return false; // No hay solapamiento
    }
    
    private static String calcularCodigoHorario() throws SQLException{
        String ultimoCodigo = HorarioDAOImpPostgres.obtenerUltimoCodigoHorario();
        int aux;
        String codigo;       
        
        if (ultimoCodigo == null){
            codigo = "HOR00001";
        } else {
            aux = Integer.parseInt(""+ultimoCodigo.charAt(3)+ultimoCodigo.charAt(4)+ultimoCodigo.charAt(5)+ultimoCodigo.charAt(6)+ultimoCodigo.charAt(7));
            aux += 1;
            if (aux < 10){
                codigo = "HOR0000"+aux;
            } else if (aux < 100){
                codigo = "HOR000"+aux;
            } else if (aux < 1000){
                codigo = "HOR00"+aux;
            } else if (aux < 10000){
                codigo = "HOR0"+aux;
            } else {
                codigo = "HOR"+aux;
            }
        }
        
        return codigo;
        
    }
}
