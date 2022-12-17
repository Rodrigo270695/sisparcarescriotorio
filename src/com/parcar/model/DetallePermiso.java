
package com.parcar.model;

import java.util.List;

public class DetallePermiso {
    
    private Rol rol;
    private List<Permiso> permisos;

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public List<Permiso> getPermisos() {
        return permisos;
    }

    public void setPermisos(List<Permiso> permisos) {
        this.permisos = permisos;
    }
    
}
