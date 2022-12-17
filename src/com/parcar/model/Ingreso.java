
package com.parcar.model;

import java.sql.*;

public class Ingreso {
    
    private String codigo;
    private String placa;
    private Timestamp fechaIngreso;
    private Timestamp fechaSalida;
    private double monto;
    private Tarifa tarifa;
    private Usuario usuario;

    public Ingreso() {
    }

    public Ingreso(String codigo, String placa, Timestamp fechaIngreso, Timestamp fechaSalida, double monto, Tarifa tarifa, Usuario usuario) {
        this.codigo = codigo;
        this.placa = placa;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.monto = monto;
        this.tarifa = tarifa;
        this.usuario = usuario;
    }

    public Ingreso(String codigo, String placa, Tarifa tarifa, Usuario usuario) {
        this.codigo = codigo;
        this.placa = placa;
        this.tarifa = tarifa;
        this.usuario = usuario;
    }

    public Ingreso(String codigo, double monto) {
        this.codigo = codigo;
        this.monto = monto;
    }

    public String getCodigo() { 
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Timestamp getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Timestamp fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Timestamp getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Timestamp fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    
}
