
package com.parcar.controller;

import com.parcar.interfaces.CRUD;
import com.parcar.model.Rol;
import com.parcar.model.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.postgresql.util.PSQLException;

public class UsuarioController implements CRUD{
    
    RolController rolC = new RolController();
    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    @Override
    public List<Object> listar(){
        
        List lista = new ArrayList<>();
        sql = "SELECT * FROM usuario ORDER BY usuario_id DESC";
        
        try {
            
            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                lista.add(new Usuario(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8), 
                        (rs.getBoolean(9)), 
                        (Rol) rolC.obtenerObjecto(rs.getInt(10))));     
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
    public void registrar(Object obj) throws Exception {
        
        Usuario usuario = (Usuario) obj;
        
        sql = "INSERT INTO usuario(documento,nombres,apellidos,fecha_nacimiento,correo,telefono,clave,rol_id) values(?,?,?,?,?,?,?,?)";
        
        try {
            
            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getDocumento());
            ps.setString(2, usuario.getNombres());
            ps.setString(3, usuario.getApellidos());
            ps.setDate(4, usuario.getFechaNacimiento());
            ps.setString(5, usuario.getCorreo());
            ps.setString(6, usuario.getTelefono());
            ps.setString(7, usuario.getClave());
            ps.setInt(8, usuario.getRol().getRolId());
            ps.executeUpdate();
            
        } catch (PSQLException pe) {
            throw new Exception("Ya existe la Usuario");
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
    public void editar(Object obj) throws Exception {
        
        Usuario usuario = (Usuario) obj;
        
        sql = "UPDATE usuario SET documento=?,nombres=?,apellidos=?,fecha_nacimiento=?,correo=?,telefono=?,clave=?,rol_id=? WHERE usuario_id = ?";
        
        try {
            
            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getDocumento());
            ps.setString(2, usuario.getNombres());
            ps.setString(3, usuario.getApellidos());
            ps.setDate(4, usuario.getFechaNacimiento());
            ps.setString(5, usuario.getCorreo());
            ps.setString(6, usuario.getTelefono());
            ps.setString(7, usuario.getClave());
            ps.setInt(8, usuario.getRol().getRolId());
            ps.setInt(9, usuario.getUsuarioId());
            ps.executeUpdate();
            
        } catch (PSQLException pe) {
            pe.printStackTrace(System.err);
            throw new Exception("Ya existe la Usuario");
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
    public void eliminar(Object obj) throws Exception {
        
        
        
    }

    @Override
    public Object obtenerObjecto(Object obj){
        
        sql = "SELECT * FROM usuario WHERE usuario_id = "+(int)obj;
        
        try {
            
            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                return new Usuario(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8), 
                        (rs.getBoolean(9)),
                        (Rol) rolC.obtenerObjecto(rs.getInt(10))); 
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
        
        return new Usuario();
        
    }

    @Override
    public List<Object> listar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public Object obtenerObjecto(String documento, String clave) throws Exception {
        
        sql = "SELECT * FROM usuario WHERE documento = '"+documento+"' AND clave = '"+clave+"' AND estado = true";
        
        try {
            
            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                return new Usuario(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8), 
                        (rs.getBoolean(9)),
                        (Rol) rolC.obtenerObjecto(rs.getInt(10))); 
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
        
        return new Usuario();
        
    }
    
}
