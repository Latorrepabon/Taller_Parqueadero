package com.unicauca.tallerparqueadero.domain;

import com.unicauca.tallerparqueadero.domain.access.Factory;

/**
 * Clase que ingresa un vehiculo calculando su respectiva tarifa
 *
 * @author Alejandro Latorre Pabón
 */
public class Ingreso {

    private int ingresoId;
    /**
     * Enumerator que representa el tipo de vehiculo ingresado
     */
    private AutoEnum tipoVehiculo;

    private int tiempo;
    /**
     * Tarifa que se calcula basado en las reglas de negocio
     */
    private int tarifa;

    public Ingreso(int ingresoId, AutoEnum tipoVehiculo, int tiempo) {
        this.ingresoId = ingresoId;
        this.tipoVehiculo = tipoVehiculo;
        this.tiempo = tiempo;
        tarifa = calcularTarifa();
    }

    public Ingreso() {
    }

    /**
     * Llama al calcular tarifa particular dependiendo del Enumerator
     * TipoVehiculo
     *
     * @return La tarifa a pagar
     */
    public int calcularTarifa() {

        if (tipoVehiculo == null || tiempo <= 0) {
            return -1;
        }
        // La fábrica devuelve una instancia de la jerarquia IDelivery  
        CalcularTarifa tarifaVehiculo = Factory.getInstance().getVehiculo(tipoVehiculo);
        int result = tarifaVehiculo.calcularTarifa(tiempo);
        return result;

    }

    public int getIngresoId() {
        return ingresoId;
    }

    public void setIngresoId(int ingresoId) {
        this.ingresoId = ingresoId;
    }

    public AutoEnum getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(AutoEnum tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public int getTarifa() {
        return tarifa;
    }

    public void setTarifa(int tarifa) {
        this.tarifa = tarifa;
    }

    /**
     *
     * @return representación en cadena de la clase Ingreso
     */
    @Override
    public String toString() {
        return "Ingreso: " + ingresoId + ", tipo de vehículo: "
                + tipoVehiculo.toString().toLowerCase() + ", tiempo: "
                + tiempo + " minutos, con un costo de:" + tarifa;
    }
}
