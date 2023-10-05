/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appSasho.capaDatos;

import com.mycompany.appSasho.capaLogica.DBConnection;
import com.mycompany.appSasho.capaLogica.Horario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author santi
 */
public class HorarioDAOImpPostgres {
    
    
    
    
    
    
    public static List<Horario> obtenerHorariosPorDia(LocalDate diaEspecifico) throws SQLException {
        List<Horario> horarios = new ArrayList<>();
        
        String id;
        LocalDate fecha;
        LocalTime horaInicio;
        LocalTime horaFin;
        
        String sql = "SELECT h_id, h_fecha, h_horaInicio, h_horaFin FROM Horarios WHERE DATE(h_fecha) = ?";
        
        try (PreparedStatement statement = DBConnection.conn.prepareStatement(sql)) {
            statement.setString(1, diaEspecifico.toString());

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    
                    id = resultSet.getString("h_id");
                    fecha = resultSet.getDate("fecha").toLocalDate();
                    horaInicio = resultSet.getTime("hora_inicio").toLocalTime();
                    horaFin = resultSet.getTime("hora_fin").toLocalTime();
                    Horario horario = new Horario(id, fecha, horaInicio, horaFin);
                    horarios.add(horario);
                }
            }
        }
        return horarios;
    }
    
}
