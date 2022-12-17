package com.parcar.controller;

import com.parcar.model.DetallePermiso;
import com.parcar.model.Permiso;
import com.parcar.model.Rol;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DetallePermisoController {

    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    public DetallePermiso listar(String documento) {

        DetallePermiso detalleP = new DetallePermiso();
        List lista = new ArrayList<>();
        sql = "select r.rol_id, r.descripcion, pe.permiso_id, pe.descripcion from usuario us\n"
                + "inner join rol r on r.rol_id = us.rol_id\n"
                + "inner join detalle_permiso dp on dp.rol_id = r.rol_id\n"
                + "inner join permiso pe on pe.permiso_id = dp.permiso_id\n"
                + "where us.documento = '"+documento+"'";
        
        try {
            
            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                detalleP.setRol(new Rol(rs.getInt(1), rs.getString(2)));
                lista.add(new Permiso(rs.getInt(3),rs.getString(4)));
            }
            detalleP.setPermisos(lista);
            
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }finally {
            try {
                if(con != null)con.close();
                if(ps != null)ps.close();
                if(rs != null)rs.close();
            } catch (SQLException e) {
                e.printStackTrace(System.err);
            }
        }
        
        return detalleP;

    }
    
    public void RegistrarPermisos(int idRol, int idPermiso){
        
        sql = "INSERT INTO detalle_permiso(rol_id,permiso_id) values(?,?)";
        
        try {
            
            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idRol);
            ps.setInt(2, idPermiso);
            ps.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }finally {
            try {
                if(con != null)con.close();
                if(ps != null)ps.close();
            } catch (SQLException e) {
                e.printStackTrace(System.err);
            }
        }
    }

    public void eliminarPermisos(int idRol){
        
        sql = "DELETE FROM detalle_permiso WHERE rol_id = ?";
        
        try {
            
            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idRol);
            ps.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }finally {
            try {
                if(con != null)con.close();
                if(ps != null)ps.close();
            } catch (SQLException e) {
                e.printStackTrace(System.err);
            }
        }
    }
    
    public DetallePermiso listar(int idRol) {

        DetallePermiso detalleP = new DetallePermiso();
        List lista = new ArrayList<>();
        sql = "SELECT * FROM detalle_permiso WHERE rol_id = "+idRol;
        
        try {
            
            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                detalleP.setRol(new Rol(rs.getInt(2)));
                lista.add(new Permiso(rs.getInt(1)));
            }
            detalleP.setPermisos(lista);
            
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }finally {
            try {
                if(con != null)con.close();
                if(ps != null)ps.close();
                if(rs != null)rs.close();
            } catch (SQLException e) {
                e.printStackTrace(System.err);
            }
        }
        
        return detalleP;

    }

}
