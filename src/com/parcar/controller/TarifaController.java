package com.parcar.controller;

import com.parcar.interfaces.CRUD;
import com.parcar.model.Tarifa;
import com.parcar.model.TipoVehiculo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.postgresql.util.PSQLException;

public class TarifaController implements CRUD {

    Conexion estado = new Conexion();
    TipoVehiculoController tipoC = new TipoVehiculoController();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";

    @Override
    public List<Object> listar() {

        List lista = new ArrayList<>();
        sql = "SELECT * FROM tarifa ORDER BY tarifa_id DESC";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(new Tarifa(
                        rs.getInt(1),
                        rs.getDouble(2),
                        rs.getDouble(3),
                        (TipoVehiculo) tipoC.obtenerObjecto(rs.getInt(4)))
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

        return lista;
    }

    @Override
    public void registrar(Object obj) throws Exception {

        Tarifa tarifa = (Tarifa) obj;

        sql = "INSERT INTO tarifa(monto_hora,monto_dia,tipo_vehiculo_id) values(?,?,?)";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setDouble(1, tarifa.getMontohora());
            ps.setDouble(2, tarifa.getMontoDía());
            ps.setInt(3, tarifa.getTipoVehiculo().getTipoVehiculoId());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe la Tarifa");
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

        Tarifa tarifa = (Tarifa) obj;

        sql = "UPDATE tarifa SET monto_hora=?,monto_dia=?,tipo_vehiculo_id=? WHERE tarifa_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setDouble(1, tarifa.getMontohora());
            ps.setDouble(2, tarifa.getMontoDía());
            ps.setInt(3, tarifa.getTipoVehiculo().getTipoVehiculoId());
            ps.setInt(4, tarifa.getTarifaId());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe la Tarifa");
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
    public void eliminar(Object obj) throws Exception {

        sql = "DELETE FROM tarifa WHERE tarifa_id = ?";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, (int) obj);
            ps.executeUpdate();

        } catch (PSQLException pe) {
            pe.printStackTrace(System.err);
            throw new Exception("El Tarifa no se puede eliminar, porque está siendo USADO");
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
    public Object obtenerObjecto(Object obj) {

        sql = "SELECT * FROM tarifa WHERE tarifa_id = " + (int) obj;

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                return new Tarifa(
                        rs.getInt(1),
                        rs.getDouble(2),
                        rs.getDouble(3),
                        (TipoVehiculo) tipoC.obtenerObjecto(rs.getInt(4))
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

        return new Tarifa();

    }

    @Override
    public List<Object> listar(Object obj) {

        List lista = new ArrayList<>();
        sql = "SELECT ta.tarifa_id,ta.monto_hora,ta.monto_dia,ta.tipo_vehiculo_id FROM tarifa ta\n"
                + "INNER JOIN tipo_vehiculo tv ON tv.tipo_vehiculo_id = ta.tipo_vehiculo_id\n"
                + "WHERE tv.descripcion LIKE '%" + obj.toString().toUpperCase() + "%'";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(new Tarifa(
                        rs.getInt(1),
                        rs.getDouble(2),
                        rs.getDouble(3),
                        (TipoVehiculo) tipoC.obtenerObjecto(rs.getInt(4))
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

    public Object obtenerObjecto(String descripcion) {

        sql = "SELECT ta.tarifa_id,ta.monto_hora,ta.monto_dia,ta.tipo_vehiculo_id FROM tarifa ta\n"
                + "INNER JOIN tipo_vehiculo tv ON tv.tipo_vehiculo_id = ta.tipo_vehiculo_id\n"
                + "WHERE tv.descripcion = '"+descripcion+"'";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                return new Tarifa(
                        rs.getInt(1),
                        rs.getDouble(2),
                        rs.getDouble(3),
                        (TipoVehiculo) tipoC.obtenerObjecto(rs.getInt(4))
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

        return new Tarifa();
    }
}
