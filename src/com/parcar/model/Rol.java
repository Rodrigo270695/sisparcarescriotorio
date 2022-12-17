
package com.parcar.model;

public class Rol {
    
    private int rolId;
    private String descripcion;

    public Rol() {
    }

    public Rol(int rolId) {
        this.rolId = rolId;
    }

    public Rol(int rolId, String descripcion) {
        this.rolId = rolId;
        this.descripcion = descripcion;
    }    

    public Rol(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getRolId() {
        return rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
