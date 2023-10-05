/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.appSasho.capaDatos;

import com.mycompany.appSasho.capaLogica.Profesor;
import java.util.List;

/**
 *
 * @author santi
 */
public interface ProfesorDAO {
    
    public void create(Profesor a);
    public List<Profesor> read();
    public void delete(int codProfesor);
    public void update(Profesor a);
    
}
