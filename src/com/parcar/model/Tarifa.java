
package com.parcar.model;

public class Tarifa {
    
    private int tarifaId;
    private double montohora;
    private double montoDía;
    private TipoVehiculo tipoVehiculo;

    public Tarifa() {
    }

    public Tarifa(int tarifaId, double montohora, double montoDía, TipoVehiculo tipoVehiculo) {
        this.tarifaId = tarifaId;
        this.montohora = montohora;
        this.montoDía = montoDía;
        this.tipoVehiculo = tipoVehiculo;
    }

    public Tarifa(double montohora, double montoDía, TipoVehiculo tipoVehiculo) {
        this.montohora = montohora;
        this.montoDía = montoDía;
        this.tipoVehiculo = tipoVehiculo;
    }

    public int getTarifaId() {
        return tarifaId;
    }

    public void setTarifaId(int tarifaId) {
        this.tarifaId = tarifaId;
    }

    public double getMontohora() {
        return montohora;
    }

    public void setMontohora(double montohora) {
        this.montohora = montohora;
    }

    public double getMontoDía() {
        return montoDía;
    }

    public void setMontoDía(double montoDía) {
        this.montoDía = montoDía;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }
    
}
