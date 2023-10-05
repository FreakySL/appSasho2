/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appSasho.capaLogica;

import java.time.LocalDate;
import java.time.LocalTime;
import com.mycompany.appSasho.capaDatos.HorarioDAOImpPostgres;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author santi
 */
public class HorarioManager {
    
    public void agregarHorario(String codHorario,LocalDate fechaHorario, LocalTime horaInicioHorario, LocalTime horaFinHorario) throws SQLException{
        
        Horario horario = new Horario(codHorario, fechaHorario, horaInicioHorario, horaFinHorario);
        
        if (!seSolapa(horario)){
            
            String comando = "INSERT INTO Horarios (h_id, h_fecha, h_horaInicio, h_horaFin) VALUES (?,?,?,?);";
            PreparedStatement pQuery = DBConnection.conn.prepareStatement(comando);
            
            java.sql.Date fechaSql = new java.sql.Date(fechaHorario.);

            new java.sql.Date
            
            pQuery.setString(1,codHorario);
            pQuery.setDate(2,fechaSql);
            pQuery.setString(3,horaInicioHorario);
            pQuery.setString(4,horaFinHorario);
            
            
        }
        
        
    }
    
    public boolean seSolapa(Horario nuevoHorario) throws SQLException {
        
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
    
    
}
