/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.appSasho.capaDatos;

import com.mycompany.appSasho.capaLogica.Horario;
import java.util.List;

/**
 *
 * @author santi
 */
public interface HorarioDAO {
    
    public void create(Horario a);
    public List<Horario> read();
    public void delete(int codHorario);
    public void update(Horario a);
    
}
