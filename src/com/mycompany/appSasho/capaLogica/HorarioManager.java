/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appSasho.capaLogica;

import java.time.LocalTime;
import com.mycompany.appSasho.capaDatos.HorarioDAOImpPostgres;
import java.sql.SQLException;
import java.util.Date;
import java.sql.PreparedStatement;
import java.util.List;

/**
 *
 * @author santi
 */
public class HorarioManager {
    
    
    private static final HorarioDAOImpPostgres horarioDAO = new HorarioDAOImpPostgres();
    

    public static void agregarHorario(Date fechaHorario, LocalTime horaInicioHorario, LocalTime horaFinHorario) throws SQLException{
        
        //LLEGA A ESTA FUNCION

        String codHorario = HorarioManager.calcularCodigoHorario();
        Horario horario = new Horario(codHorario, fechaHorario, horaInicioHorario, horaFinHorario);
        
        
        System.out.println("Estoy previo a ver si se solapa horario");
            
        horarioDAO.create(horario);
        // el dao recibe como parametro el objeto completo

        
    }
    
    public static boolean seSolapa(java.util.Date fecha, LocalTime horaInicio, LocalTime horaFin) throws SQLException {
        
        List <Horario> horarios;
        
        LocalTime horaFinalDelAnterior;
        
        
        horarios = HorarioDAOImpPostgres.obtenerHorariosPorDia(fecha);
        
        for (Horario horarioExistente : horarios) {
            
            if(horaInicio.equals(horarioExistente.getHoraInicio()) && horaFin.equals(horarioExistente.getHoraFin())){
                System.out.println("CASO 1");
                return true;
            }
            
            if (horaInicio.equals(horarioExistente.getHoraInicio()) && horaFin.isBefore(horarioExistente.getHoraFin())){
                System.out.println("CASO 2");
                return true;
            }
            
            
            if (horaFin.equals(horarioExistente.getHoraFin()) && horaInicio.isAfter(horarioExistente.getHoraInicio())){
                System.out.println("CASO 3");
                return true;
            }
            
            
            if (horaInicio.isBefore(horarioExistente.getHoraFin()) && horaFin.isAfter(horarioExistente.getHoraFin())){
                System.out.println("CASO 4");
                return true;
            }
            
            
            if (horaInicio.isBefore(horarioExistente.getHoraInicio()) && horaFin.isAfter(horarioExistente.getHoraInicio())){
                System.out.println("CASO 5");
                return true;
            }
            
            /*
            if (!horaFin.isBefore(horarioExistente.getHoraInicio()) &&
                !horaInicio.isAfter(horarioExistente.getHoraFin())) {
                return true; // Hay solapamiento
            }

            */
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
