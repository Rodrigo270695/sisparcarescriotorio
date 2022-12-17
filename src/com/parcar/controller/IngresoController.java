
package com.parcar.controller;

import com.parcar.interfaces.CRUD;
import com.parcar.model.Ingreso;
import com.parcar.model.Tarifa;
import com.parcar.model.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IngresoController implements CRUD{
    
    Conexion estado = new Conexion();
    TarifaController tarifaC = new TarifaController();
    UsuarioController usuarioC = new UsuarioController();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    @Override
    public List<Object> listar(){
        
        List lista = new ArrayList<>();
        sql = "SELECT * FROM ingreso ORDER BY fecha_ingreso DESC";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(new Ingreso(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getTimestamp(3),
                        rs.getTimestamp(4),
                        rs.getDouble(5),
                        (Tarifa) tarifaC.obtenerObjecto(rs.getInt(6)),
                        (Usuario) usuarioC.obtenerObjecto(rs.getInt(7))
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace(System.err);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace(System.err);
            }
        }

        return lista;
        
    }

    @Override
    public void registrar(Object obj) throws Exception {
        
        Ingreso ingreso = (Ingreso) obj;

        sql = "INSERT INTO ingreso(codigo,placa,tarifa_id,usuario_id) values(?,?,?,?)";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, ingreso.getCodigo());
            ps.setString(2, ingreso.getPlaca());
            ps.setInt(3, ingreso.getTarifa().getTarifaId());
            ps.setInt(4, ingreso.getUsuario().getUsuarioId());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.err);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace(System.err);
            }
        }
        
    }

    @Override
    public void editar(Object obj) throws Exception {
        
        Ingreso ingreso = (Ingreso) obj;
        sql = "UPDATE ingreso SET fecha_salida = now(), monto = ? WHERE codigo = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setDouble(1, ingreso.getMonto());
            ps.setString(2, ingreso.getCodigo());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.err);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace(System.err);
            }
        }
        
    }

    @Override
    public void eliminar(Object obj) {
        
        sql = "DELETE FROM ingreso WHERE codigo = '"+obj.toString()+"'";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.err);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.err);
            }
        }
        
    }

    @Override
    public Object obtenerObjecto(Object obj){
        
        sql = "SELECT * FROM ingreso WHERE codigo = '"+obj.toString()+"'";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                return new Ingreso(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getTimestamp(3),
                        rs.getTimestamp(4),
                        rs.getDouble(5),
                        (Tarifa) tarifaC.obtenerObjecto(rs.getInt(6)),
                        (Usuario) usuarioC.obtenerObjecto(rs.getInt(7))
                );
            }

        } catch (SQLException e) {
            e.printStackTrace(System.err);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace(System.err);
            }
        }

        return new Ingreso();
        
    }

    @Override
    public List<Object> listar(Object obj) {
        
        List lista = new ArrayList<>();
        sql = "SELECT * FROM ingreso WHERE placa LIKE '%"+obj.toString()+"%'";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(new Ingreso(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getTimestamp(3),
                        rs.getTimestamp(4),
                        rs.getDouble(5),
                        (Tarifa) tarifaC.obtenerObjecto(rs.getInt(6)),
                        (Usuario) usuarioC.obtenerObjecto(rs.getInt(7))
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace(System.err);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace(System.err);
            }
        }

        return lista;
        
    }
    
    
}
