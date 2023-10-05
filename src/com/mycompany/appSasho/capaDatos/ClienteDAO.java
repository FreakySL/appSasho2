/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.appSasho.capaDatos;

import com.mycompany.appSasho.capaLogica.Cliente;
import java.util.List;

/**
 *
 * @author santi
 */
public interface ClienteDAO {
    
    public void create(Cliente a);
    public List<Cliente> read();
    public void delete(int codCliente);
    public void update(Cliente a);
    
}
