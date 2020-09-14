package com.unicauca.tallerparqueadero.domain;

/**
 * Clase que implemente la interfaz CalcularTarifa basado en las reglas de
 * negocio de una moto
 *
 * @author Alejandro Latorre Pabón
 */
public class TarifaMoto extends CalcularTarifa {

    /**
     * Calcula la tarifa que debe pagar un vehiciulo un camión basado en las
     * reglas de negocio
     *
     * @param minutos Tiempo pasada en el Parqueadero
     * @return la tarifa a pagar
     */
    @Override
    public int calcularTarifa(int minutos) {
        tarifa = 1000;
        if (minutos > 60) {
            tarifa += (minutos - 60) * (25 / 3);
            tarifa = redondearCentena(tarifa);
        }
        return tarifa;
    }
}
