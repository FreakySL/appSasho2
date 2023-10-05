/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.appSasho.capaDatos;

import com.mycompany.appSasho.capaLogica.Horario;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author santi
 */
public interface HorarioDAO {
    
    public void create(String codHorario,Date fechaHorario, LocalTime horaInicioHorario, LocalTime horaFinHorario) throws SQLException;
    public List<Horario> read() throws SQLException;
    public void delete(int codHorario);
    public void update(Horario a);
}
