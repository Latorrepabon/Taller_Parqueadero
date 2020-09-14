package com.unicauca.tallerparqueadero.domain;

/**
 * Clase abstarcta con el método abstracto Calcular Tarifa, y el método
 * Redondear
 *
 * @author Alejandro Latorre Pabón
 */
public abstract class CalcularTarifa {

    /**
     * Cantidad de dinero que debe pagar el vehiculo
     */
    protected int tarifa;

    /**
     * Recibe un entero y lo redondea a la centena superior más cerca
     *
     * @param valor
     * @return El valor redondeado a la centena
     */
    protected int redondearCentena(int valor) {
        int residuo = valor % 100;
        if (residuo != 0) {
            valor += 100 - residuo;
        }
        return valor;
    }

    /**
     * Calcula la tarifa que debe pagar un vehiciulo en el parqueadero
     *
     * @param minutos Tiempo pasada en el Parqueadero
     * @return la tarifa a pagar
     */
    abstract public int calcularTarifa(int minutos);

}
