/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appSasho.capaLogica;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Array;
import java.sql.Connection;

/**
 *
 * @author santi
 */
public class DBConnection {
    
    private static DBConnection instance = null;
    private static final String DB_NAME = "sashoAppDB";
    private static final String url = "jdbc:postgresql://localhost:5432/" + DB_NAME;
    private static final String user = "postgres";
    private static final String password = "123456";
    
    private static Statement query = null;
    private static PreparedStatement p_query = null;
    private static ResultSet result = null;
    
    private static Connection conn = null;
    
    
    private static void conectar() throws SQLException {
        
        instance = new DBConnection();
        try {
            conn = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static DBConnection getConnection() throws SQLException{
        
        if (instance == null)
            conectar();
        
        return instance;
    }   
}
