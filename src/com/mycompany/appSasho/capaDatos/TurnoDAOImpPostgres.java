/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appSasho.capaDatos;

import com.mycompany.appSasho.capaLogica.DBConnection;
import com.mycompany.appSasho.capaLogica.Horario;
import com.mycompany.appSasho.capaLogica.Turno;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author santi
 */
public class TurnoDAOImpPostgres implements TurnoDAO{
    
    
    @Override
    public void create(String codTurno,int tipoServicio, float costo, int codCliente, String codHorario) throws SQLException{
        
        String comando = "INSERT INTO Turnos (t_id, t_tipo, t_costo, per_IDCliente, h_id) VALUES (?,?,?,?,?);";
            PreparedStatement pQuery = DBConnection.conn.prepareStatement(comando);
            
            pQuery.setString(1,codTurno);
            pQuery.setInt(2,tipoServicio);
            pQuery.setFloat(3,costo);
            pQuery.setInt(4,codCliente);
            pQuery.setString(5,codHorario);
            
            
            pQuery.executeUpdate();
        
    }
    @Override
    public List<Turno> read() throws SQLException{
        
        List<Turno> turnos = new ArrayList<>();
        
        String codTurno;
        int tipoServicio; 
        float costo;
        int codCliente;
        String codHorario;
        
        
        String sql = "SELECT t_id, t_tipo, t_costo, per_IDCliente, h_id FROM Turnos";
        
        try (Statement query = DBConnection.conn.createStatement()) {

            try (ResultSet resultSet = query.executeQuery(sql)) {
                while (resultSet.next()) {
                    
                    codTurno = resultSet.getString("t_id");
                    tipoServicio = resultSet.getInt("t_tipo");
                    costo = resultSet.getFloat("t_costo");
                    codCliente = resultSet.getInt("per_IDCliente");
                    codHorario = resultSet.getString("h_id").;
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
    public void delete(int codTurno);
    public void update(Turno a);
    
}
