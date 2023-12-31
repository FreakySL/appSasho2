/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.appSasho.capaDatos;

import com.mycompany.appSasho.capaLogica.Turno;
import java.util.List;
import java.sql.SQLException;

/**
 *
 * @author santi
 */
public interface TurnoDAO {
    
    public void create(Turno turno) throws SQLException;
    public List<Turno> read() throws SQLException;
    public void delete(int codTurno);
    public void update(Turno a);
    
}
