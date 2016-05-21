/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koubeck.libros;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Miguel
 */
@ManagedBean
@ViewScoped
public class ListaClientes implements Serializable {
        

    private List<Cliente> clientes;


    
    @ManagedProperty("#{clienteService}")
    private ClienteService service;
    
    private Cliente selectedCliente;
    
    
    @PostConstruct
    public void init(){
        clientes = service.createCliente();
    }

    
    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    public void setService(ClienteService service) {
        this.service = service;
    }
 
    public Cliente getSelectedCliente() {
        return selectedCliente;
    }
 
    public void setSelectedCliente(Cliente selectedCliente) {
        this.selectedCliente = selectedCliente;
    }
    
    /*
    public void guardaCliente(Cliente cliente) throws SQLException, Exception{
        DbDriverConnection.insert(cliente.getNombre(),cliente.getYear(),
                cliente.getMon(),cliente.getDay(),cliente.getVisitas());
    }
    */
    
}
