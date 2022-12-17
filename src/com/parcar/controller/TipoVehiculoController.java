
package com.parcar.controller;

import com.parcar.interfaces.CRUD;
import com.parcar.model.TipoVehiculo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.postgresql.util.PSQLException;

public class TipoVehiculoController implements CRUD{
    
    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    @Override
    public List<Object> listar() {
        
        List lista = new ArrayList<>();
        sql = "SELECT * FROM tipo_vehiculo ORDER BY tipo_vehiculo_id DESC";
        
        try {
            
            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                lista.add(new TipoVehiculo(
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
        
        TipoVehiculo tipoV = (TipoVehiculo) obj;
        
        sql = "INSERT INTO tipo_vehiculo(descripcion) values(?)";
        
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
        
        TipoVehiculo tipoV = (TipoVehiculo) obj;
        
        sql = "UPDATE tipo_vehiculo SET descripcion = ? WHERE tipo_vehiculo_id = ?";
        
        try {
            
            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, tipoV.getDescripcion());
            ps.setInt(2, tipoV.getTipoVehiculoId());
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
        
        sql = "DELETE FROM tipo_vehiculo WHERE tipo_vehiculo_id = ?";

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
        
        sql = "SELECT * FROM tipo_vehiculo WHERE tipo_vehiculo_id = "+(int)obj;
        
        try {
            
            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                return new TipoVehiculo(rs.getInt(1),rs.getString(2));    
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
        
        return new TipoVehiculo();
        
    }

    @Override
    public List<Object> listar(Object obj) {
        
        List lista = new ArrayList<>();
        sql = "SELECT * FROM tipo_vehiculo where descripcion LIKE '%"+obj+"%'";
        
        try {
            
            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                lista.add(new TipoVehiculo(
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
    
    public Object obtenerObjecto(String descripcion) {
        
        sql = "SELECT * FROM tipo_vehiculo WHERE descripcion = '"+descripcion+"'";
        
        try {
            
            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                return new TipoVehiculo(rs.getInt(1),rs.getString(2));    
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
        
        return new TipoVehiculo();
        
    }
    
}
