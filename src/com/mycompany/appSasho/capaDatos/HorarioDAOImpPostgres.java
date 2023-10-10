/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appSasho.capaDatos;

import com.mycompany.appSasho.capaLogica.DBConnection;
import com.mycompany.appSasho.capaLogica.Horario;
import java.sql.Date;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author santi
 */
public class HorarioDAOImpPostgres implements HorarioDAO{
    
    
    @Override
    public void create(Horario horario) throws SQLException{
        
        System.out.println("Llegue al create del dao horarios");
        
        String comando = "INSERT INTO Horarios (h_id, h_fecha, h_horaInicio, h_horaFin) VALUES (?,?,?,?);";
            PreparedStatement pQuery = DBConnection.conn.prepareStatement(comando);
            
            java.sql.Date fechaSql = new java.sql.Date(horario.getFecha().getTime());
            
            Time horaInicioSQL = Time.valueOf(horario.getHoraInicio());
            Time horaFinSQL = Time.valueOf(horario.getHoraFin());
            
            pQuery.setString(1,horario.getCodHorario());
            pQuery.setDate(2,fechaSql);
            pQuery.setTime(3,horaInicioSQL);
            pQuery.setTime(4,horaFinSQL);
            
            pQuery.executeUpdate();
        
    }

    
    @Override
    public List<Horario> read() throws SQLException{
        
        List<Horario> horarios = new ArrayList<>();
        
        String id;
        Date fecha;
        LocalTime horaInicio;
        LocalTime horaFin;
        
        String sql = "SELECT h_id, h_fecha, h_horaInicio, h_horaFin FROM Horarios";
        
        try (Statement query = DBConnection.conn.createStatement()) {

            try (ResultSet resultSet = query.executeQuery(sql)) {
                while (resultSet.next()) {
                    
                    id = resultSet.getString("h_id");
                    fecha = resultSet.getDate("fecha");
                    horaInicio = resultSet.getTime("hora_inicio").toLocalTime();
                    horaFin = resultSet.getTime("hora_fin").toLocalTime();
                    Horario horario = new Horario(id, fecha, horaInicio, horaFin);
                    horarios.add(horario);
                }
            }
        }
        return horarios;   
    }
    
    
    public Horario readOne(String idConsulta) throws SQLException{
        
        String id;
        Date fecha;
        LocalTime horaInicio;
        LocalTime horaFin;
        
        String sql = "SELECT h_id, h_fecha, h_horaInicio, h_horaFin FROM Turno WHERE h_id = ?";
        try (PreparedStatement statement = DBConnection.conn.prepareStatement(sql)) {
            statement.setString(1, idConsulta);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    
                    id = resultSet.getString("h_id");
                    fecha = resultSet.getDate("fecha");
                    horaInicio = resultSet.getTime("hora_inicio").toLocalTime();
                    horaFin = resultSet.getTime("hora_fin").toLocalTime();
                    Horario horario = new Horario(id, fecha, horaInicio, horaFin);

                    return horario;
                }
            }
        }
        return null;
    }
    
    
    public static List<Horario> obtenerHorariosPorDia(java.util.Date diaEspecifico) throws SQLException {
        List<Horario> horarios = new ArrayList<>();
        
        String id;
        java.util.Date fechaJava;
        java.sql.Date fechaSql = new java.sql.Date(diaEspecifico.getTime());
        LocalTime horaInicio;
        LocalTime horaFin;
        
        String sql = "SELECT h_id, h_fecha, h_horaInicio, h_horaFin FROM Horarios WHERE DATE(h_fecha) = ?";
        
        try (PreparedStatement statement = DBConnection.conn.prepareStatement(sql)) {
            statement.setDate(1, fechaSql);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                
                    id = resultSet.getString("h_id");
                    fechaJava = resultSet.getDate("fecha");
                    horaInicio = resultSet.getTime("hora_inicio").toLocalTime();
                    horaFin = resultSet.getTime("hora_fin").toLocalTime();
                    Horario horario = new Horario(id, fechaJava, horaInicio, horaFin);
                    horarios.add(horario);
                }
            }
        }
        return horarios;
    }
    
    public static String obtenerUltimoCodigoHorario () throws SQLException {
        String id = null;
        String sql = "SELECT MAX(h_id) FROM Horarios;";
        
        try (Statement query = DBConnection.conn.createStatement()) {

            try (ResultSet resultSet = query.executeQuery(sql)) {
                while (resultSet.next()) {
                    
                    id = resultSet.getString("max");

                }
            }
        }
        
        return id;
    }


    @Override
    public void delete(int codHorario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Horario a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
