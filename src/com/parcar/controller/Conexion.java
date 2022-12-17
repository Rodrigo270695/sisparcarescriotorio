
package com.parcar.controller;

import java.sql.*;

public class Conexion {
    
    private final String URL = "jdbc:postgresql://localhost:5432/bd_parqueamiento";
    private final String USER = "postgres";
    private final String PASS = "admin";
    
    public Connection conectar(){
        
        Connection con = null;
        
        try {
            
            con = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
        
        return con;
        
    }
    
}
