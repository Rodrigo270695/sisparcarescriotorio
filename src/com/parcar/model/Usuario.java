
package com.parcar.model;

import java.sql.*;

public class Usuario {
    
    private int usuarioId;
    private String documento;
    private String nombres;
    private String apellidos;
    private Date fechaNacimiento;
    private String correo;
    private String telefono;
    private String clave;
    private boolean estado;
    private Rol rol;

    public Usuario(int usuarioId, String documento, String nombres, String apellidos, Date fechaNacimiento, String correo, String telefono, String clave, boolean estado, Rol rol) {
        this.usuarioId = usuarioId;
        this.documento = documento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
        this.telefono = telefono;
        this.clave = clave;
        this.estado = estado;
        this.rol = rol;
    }

    public Usuario(String documento, String nombres, String apellidos, Date fechaNacimiento, String correo, String telefono, String clave, Rol rol) {
        this.documento = documento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
        this.telefono = telefono;
        this.clave = clave;
        this.rol = rol;
    }

    public Usuario() {
    }

    
    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
}
