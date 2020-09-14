package com.unicauca.tallerparqueadero.domain;

import com.unicauca.tallerparqueadero.domain.access.IRandomNumberGenerator;

/**
 * Clase que implemente la interfaz CalcularTarifa basado 
 * en las reglas de negocio de un camión
 * 
 * @author Alejandro Latorre Pabón
 */
public class TarifaCamion extends CalcularTarifa {

    public TarifaCamion(IRandomNumberGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    private IRandomNumberGenerator randomGenerator;

    /**
     * Calcula la tarifa que debe pagar un vehiciulo un camión basado en las
     * reglas de negocio
     *
     * @param minutos Tiempo pasada en el Parqueadero
     * @return la tarifa a pagar
     */
    @Override
    public int calcularTarifa(int minutos) {
        tarifa = 15000;
        if (minutos < 720) {
            tarifa = 10000;
        } else if (minutos > 1440) {
            tarifa += (minutos - 1440) * (125.0 / 12.0);
            tarifa = redondearCentena(tarifa);
        }

        if (Sortear()) {
            tarifa = 0;
        }

        return tarifa;
    }

    /**
     * Determina si un camión ganó el sorteo
     *
     * @return True si el camión ganó el sorteo, falso de lo contrarario
     */
    private boolean Sortear() {
        int numeroAleatorio = randomGenerator.getRandomNumber();
        return tarifa % numeroAleatorio == 0;
    }

    public void setRandomGenerator(IRandomNumberGenerator randomNumber) {
        this.randomGenerator = randomNumber;
    }

}
