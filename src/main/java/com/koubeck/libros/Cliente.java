/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koubeck.libros;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Miguel
 */
public class Cliente implements Serializable{

    int id;
    String nombre;
    String tarjeta;
    String fecha;
    String telefono;
    int visitas;
    
    Cliente(){
        id = 0;
        nombre = "Sin nombre";
        tarjeta = "1234567890";
        fecha = "2000-01-01";
        telefono = "5512345678";
        visitas = 0;
    }
    
    Cliente(int idt, String nombret, String tarjetat, String fechat, String telefonot, int visitast){
        id = idt;
        nombre = nombret;
        tarjeta = tarjetat;
        fecha = fechat;
        telefono = telefonot;
        visitas = visitast;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getVisitas() {
        return visitas;
    }

    public void setVisitas(int visitas) {
        this.visitas = visitas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.visitas != other.visitas) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.tarjeta, other.tarjeta)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        return Objects.equals(this.telefono, other.telefono);
    }


    
    @Override
    public String toString(){
        return ""+ id + "\t" + nombre + "\t" + tarjeta + "\t" + fecha + "\t" + telefono + "\n";
    }
    
}
