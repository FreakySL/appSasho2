/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appSasho.capaDatos;

import com.mycompany.appSasho.capaLogica.Turno;
import java.util.List;

/**
 *
 * @author santi
 */
public class TurnoDAOImpPostgres implements TurnoDAO{
    
    
    public void create(Turno a){
    
        String comando = "INSERT INTO ";
    
    }
    public List<Turno> read(){
        
        return ;
        
    }
    public void delete(int codTurno);
    public void update(Turno a);
    
}
