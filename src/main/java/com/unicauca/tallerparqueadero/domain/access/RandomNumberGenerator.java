package com.unicauca.tallerparqueadero.domain.access;

/**
 * Clase que genera un numero aleatorio
 *
 * @author Alejandro Latorre Pabón
 */
public class RandomNumberGenerator implements IRandomNumberGenerator {

    /**
     *
     * @return Un numero aleatorio entre 1 y 1000
     */
    @Override
    public int getRandomNumber() {
        return (int) (Math.random() * (1000 - 1)) + 1;
    }

}
