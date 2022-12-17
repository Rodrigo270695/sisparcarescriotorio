
package com.parcar.controller;

import com.parcar.interfaces.CRUD;
import com.parcar.model.Rol;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.postgresql.util.PSQLException;

public class RolController implements CRUD{
    
    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    @Override
    public List<Object> listar() {
        
        List lista = new ArrayList<>();
        sql = "SELECT * FROM rol ORDER BY rol_id DESC";
        
        try {
            
            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                lista.add(new Rol(
                        rs.getInt(1),
                        rs.getString(2)
                ));     
            }
            
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
        
        return lista;
    }

    @Override
    public void registrar(Object obj) throws Exception{
        
        Rol tipoV = (Rol) obj;
        
        sql = "INSERT INTO rol(descripcion) values(?)";
        
        try {
            
            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, tipoV.getDescripcion());
            ps.executeUpdate();
            
        } catch (PSQLException pe) {
            throw new Exception("Ya existe la tipo");
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

    @Override
    public void editar(Object obj) throws Exception{
        
        Rol tipoV = (Rol) obj;
        
        sql = "UPDATE rol SET descripcion = ? WHERE rol_id = ?";
        
        try {
            
            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, tipoV.getDescripcion());
            ps.setInt(2, tipoV.getRolId());
            ps.executeUpdate();
            
        } catch (PSQLException pe) {
            throw new Exception("Ya existe la tipo");
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

    @Override
    public void eliminar(Object obj) throws Exception{
        
        sql = "DELETE FROM rol WHERE rol_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, (int)obj);
            ps.executeUpdate();

        } catch (PSQLException pe) {
            pe.printStackTrace(System.err);
            throw new Exception("El tipo no se puede eliminar, porque está siendo USADO");
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        } finally {
            try {
                if(con != null)con.close();
                if(ps != null)ps.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.err);
            }
        }
        
    }

    @Override
    public Object obtenerObjecto(Object obj) {
        
        sql = "SELECT * FROM rol WHERE rol_id = "+(int)obj;
        
        try {
            
            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                return new Rol(rs.getInt(1),rs.getString(2));    
            }
            
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
        
        return new Rol();
        
    }

    @Override
    public List<Object> listar(Object obj) {
        
        List lista = new ArrayList<>();
        sql = "SELECT * FROM rol where descripcion LIKE '%"+obj+"%'";
        
        try {
            
            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                lista.add(new Rol(
                        rs.getInt(1),
                        rs.getString(2)
                ));     
            }
            
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
        
        return lista;
        
    }
    
    public Object obtenerObjecto(String obj) {
        
        sql = "SELECT * FROM rol WHERE descripcion = '"+obj+"'";
        
        try {
            
            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                return new Rol(rs.getInt(1),rs.getString(2));    
            }
            
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
        
        return new Rol();
        
    }
}
