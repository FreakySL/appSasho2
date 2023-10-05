/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.appSasho.capaDatos;


import com.mycompany.appSasho.capaLogica.Curso;
import java.util.List;

/**
 *
 * @author santi
 */
public interface CursoDAO {
    
    public void create(Curso a);
    public List<Curso> read();
    public void delete(int codCurso);
    public void update(Curso a);
    
}
