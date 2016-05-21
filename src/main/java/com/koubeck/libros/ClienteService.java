/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koubeck.libros;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
/**
 *
 * @author Miguel
 */
@ManagedBean(name = "clienteService")
@ApplicationScoped
public class ClienteService {
    
    public List<Cliente> createCliente(){
        try {
            return DbDriverConnection.consultaClientes();
        } catch (Exception ex) {
        }
        return new ArrayList<>();
    }
    
    /*
    public void guardaCliente(Cliente cliente) throws SQLException, Exception{
        DbDriverConnection.insert(cliente.getNombre(),cliente.getYear(),cliente.getMon(),cliente.getDay(),cliente.getVisitas());
    }
*/
}
