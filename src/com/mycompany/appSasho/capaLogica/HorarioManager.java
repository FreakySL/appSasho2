/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appSasho.capaLogica;

import java.time.LocalTime;
import com.mycompany.appSasho.capaDatos.HorarioDAOImpPostgres;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Time;
import java.sql.PreparedStatement;
import java.util.List;

/**
 *
 * @author santi
 */
public class HorarioManager {
    
    
    private static final HorarioDAOImpPostgres horarioDAO = new HorarioDAOImpPostgres();
    
    public void agregarHorario(String codHorario,Date fechaHorario, LocalTime horaInicioHorario, LocalTime horaFinHorario) throws SQLException{
        
        Horario horario = new Horario(codHorario, fechaHorario, horaInicioHorario, horaFinHorario);
        
        if (!seSolapa(horario)){
            
            horarioDAO.create(codHorario, fechaHorario, horaInicioHorario, horaFinHorario);
            
        }
        
        
    }
    
    private boolean seSolapa(Horario nuevoHorario) throws SQLException {
        
        List <Horario> horarios;
        
        horarios = HorarioDAOImpPostgres.obtenerHorariosPorDia((Date) nuevoHorario.getFecha());
        
        for (Horario horarioExistente : horarios) {
            if (!nuevoHorario.getHoraFin().isBefore(horarioExistente.getHoraInicio()) &&
                !nuevoHorario.getHoraInicio().isAfter(horarioExistente.getHoraFin())) {
                return true; // Hay solapamiento
            }
        }
        return false; // No hay solapamiento
    }
    
    
}
