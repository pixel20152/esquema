/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koubeck.libros;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 

/**
 *
 * @author Miguel
 */
public class  DbDriverConnection{
 
    
    public static void main(String[] args) throws Exception {
 
        //consulta();

        List<Cliente> lista = consultaClientes();
        for(int i = 0; i<lista.size(); i++){
        System.out.println(lista.get(i).toString());
        }
    }   

    public static void consulta() throws SQLException, Exception{
        Class.forName("com.mysql.jdbc.Driver");
        String jdbcUrl = "jdbc:mysql://localhost:3306/cine";
        String username = "root";
        String password = "miguel-ito";
 
        Connection connection = null;
        try {
            System.out.println("Conectando a la base de datos...");
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Base de datos conectada!");
            
            
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM clientes");
        
            String query = "";
            System.out.println("id \t nombre \t tarjeta \t fecha \t telefono \t visitas \n");
            int id;
            String nombre;
            String tarjeta;
            String fechan;
            String telefono;
            String visitas;
            while(resultSet.next()) {
                id = resultSet.getInt("id");
                nombre = resultSet.getString("Nombre");
                tarjeta = resultSet.getString("Tarjeta");
                fechan = resultSet.getString("F_Nacimiento");
                telefono = resultSet.getString("Telefono");
                visitas = resultSet.getString("Visitas");

                query = query+id+"\t"+nombre+"\t"+tarjeta+"\t"+fechan+"\t"+telefono+"\t"+visitas+"\n";
            }
            
            
            System.out.println(query);

        } catch (SQLException e) {
            throw new RuntimeException("¡No se puede conectar a la base de datos!", e);
        } finally {
            System.out.println("Cerrando la conexión.");
            if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
        }   

    }
 
    public static void insert(String nombre,int year,int mon, int day,int visitas) throws SQLException, Exception{
        
        Class.forName("com.mysql.jdbc.Driver");
        String jdbcUrl = "jdbc:mysql://localhost:3306/prueba";
        String username = "root";
        String password = "miguel-ito";
 
        Connection connection = null;
        try {
            System.out.println("Connecting database...");
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Database connected!");
            
            String query="";

            Statement statement = connection.createStatement();
            String insertTableSQL = "INSERT INTO clientes(Nombre, Fecha_Nacimiento, Visitas)"
                    +" VALUES('"+nombre+"',DATE('"+year+"-"+mon+"-"+day+"'),"+visitas+");";

            System.out.println(insertTableSQL);
            // execute insert SQL stetement
            statement.executeUpdate(insertTableSQL);
            System.out.println("Insercion exitosa");

        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect the database!", e);
        } finally {
            System.out.println("Closing the connection.");
            if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
        }  
    }
    
    private static String query(Connection connection) throws SQLException{
 
        String query="";
        
        String nombre ="Miguel"; 
        int year = 2010;
        int mon = 10;
        int day = 23;
        int vis = 12;
        
         Statement statement = connection.createStatement();
        String insertTableSQL = "INSERT INTO clientes(Nombre, Fecha_Nacimiento,Visitas)"
                +" VALUES('"+nombre+"',DATE('"+year+"-"+mon+"-"+day+"'),"+vis+");";
        
        System.out.println(insertTableSQL);
        // execute insert SQL stetement
        statement.executeUpdate(insertTableSQL);
        
        ResultSet resultSet = statement.executeQuery("SELECT * FROM clientes");
        
        System.out.println("id \t Nombre \t fecha \t visitas \n");
        while(resultSet.next()) {
            int id = resultSet.getInt("ID");
            String nimi = resultSet.getString("Nombre");
            String fecha = resultSet.getString("Fecha_Nacimiento");
            String visit = resultSet.getString("Visitas");
 
            query = query + id + "\t" + nimi + "\t" + fecha + "\t"+ visit + "\n";
        }
        return query;
    }
    
    
    public static List<Cliente> consultaClientes() throws SQLException, Exception{
        Class.forName("com.mysql.jdbc.Driver");
        String jdbcUrl = "jdbc:mysql://localhost:3306/cine";
        String username = "root";
        String password = "miguel-ito";
 
        Connection connection = null;
        List<Cliente> listaConsulta = new ArrayList<Cliente>();

        try {
            System.out.println("Conectando a la base de datos...");
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Base de datos conectada!");
            
            
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM clientes");
        
            while(resultSet.next()) {
                listaConsulta.add(new Cliente(resultSet.getInt("id"), resultSet.getString("Nombre"),
                        resultSet.getString("Tarjeta"), resultSet.getString("F_Nacimiento"),resultSet.getString("Telefono"),
                        resultSet.getInt("Visitas")));
            }
                        
        } catch (SQLException e) {
            throw new RuntimeException("¡No se puede conectar a la base de datos!", e);
        } finally {
            System.out.println("Cerrando la conexión.");
            if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
        }   
        return listaConsulta;
    }
}