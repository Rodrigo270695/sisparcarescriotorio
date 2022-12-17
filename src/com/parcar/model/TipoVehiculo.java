
package com.parcar.model;

public class TipoVehiculo {
    
    private int tipoVehiculoId;
    private String descripcion;

    public TipoVehiculo() {
    }

    public TipoVehiculo(int tipoVehiculoId, String descripcion) {
        this.tipoVehiculoId = tipoVehiculoId;
        this.descripcion = descripcion;
    }

    public TipoVehiculo(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getTipoVehiculoId() {
        return tipoVehiculoId;
    }

    public void setTipoVehiculoId(int tipoVehiculoId) {
        this.tipoVehiculoId = tipoVehiculoId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
