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
    public void create(Turno turno) throws SQLException{
        
        String comando = "INSERT INTO Turnos (t_id, t_tipo, t_costo, per_IDCliente, h_id) VALUES (?,?,?,?,?);";
            PreparedStatement pQuery = DBConnection.conn.prepareStatement(comando);
            
            pQuery.setString(1,turno.getCodTurno());
            pQuery.setInt(2,turno.getTipoServicio());
            pQuery.setFloat(3,turno.getCosto());
            pQuery.setInt(4,turno.getCodCliente());
            pQuery.setString(5,turno.getCodHorario());
            
            
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
                    codHorario = resultSet.getString("h_id");
                    Turno turno = new Turno(codTurno, tipoServicio, costo, codCliente, codHorario);
                    turnos.add(turno);
                }
            }
        }
        return turnos;   
    }
    
    
    public Turno readOne(String idConsulta) throws SQLException{
        
        String codTurno;
        int tipoServicio; 
        float costo;
        int codCliente;
        String codHorario;
        
        String sql = "SELECT t_id, t_tipo, t_costo, per_IDCliente, h_id FROM Turnos WHERE h_id = ?";
        try (PreparedStatement statement = DBConnection.conn.prepareStatement(sql)) {
            statement.setString(1, idConsulta);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    
                    codTurno = resultSet.getString("t_id");
                    tipoServicio = resultSet.getInt("t_tipo");
                    costo = resultSet.getFloat("t_costo");
                    codCliente = resultSet.getInt("per_IDCliente");
                    codHorario = resultSet.getString("h_id");
                    Turno turno = new Turno(codTurno, tipoServicio, costo, codCliente, codHorario);

                    return turno;
                }
            }
        }
        return null;
    }
    
    public static String obtenerUltimoCodigoTurnos () throws SQLException {
        String id = null;
        String sql = "SELECT MAX(h_id) FROM Turnos;";
        
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
    public void delete(int codTurno) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Turno a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
