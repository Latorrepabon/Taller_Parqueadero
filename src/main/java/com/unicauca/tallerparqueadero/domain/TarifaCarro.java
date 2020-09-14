package com.unicauca.tallerparqueadero.domain;

/**
 * Clase que implemente la interfaz CalcularTarifa basado 
 * en las reglas de negocio de un Carro
 * 
 * @author Alejandro Latorre Pabón
 */
public class TarifaCarro extends CalcularTarifa {

    /**
     * Calcula la tarifa que debe pagar un vehiciulo un camión basado en las
     * reglas de negocio
     *
     * @param minutos Tiempo pasada en el Parqueadero
     * @return la tarifa a pagar
     */
    @Override
    public int calcularTarifa(int minutos) {
        tarifa = 2000;
        if (minutos > 60) {
            tarifa += (minutos - 60) * (50 / 3);
            tarifa = redondearCentena(tarifa);
        }
        return tarifa;
    }
}
