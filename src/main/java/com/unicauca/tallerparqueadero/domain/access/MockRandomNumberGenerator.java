package com.unicauca.tallerparqueadero.domain.access;

/**
 * Clase que genera un número predefinido (falsamente aleotorio) con el fin de
 * poder probar las funcionalidades de las clases que implementen
 * IRandomNumberGenerator
 *
 * @author Alejandro Latorre Pabón
 */
public class MockRandomNumberGenerator implements IRandomNumberGenerator {

    private int fakeRandomNumber;

    public MockRandomNumberGenerator(int fakeRandomNumber) {
        this.fakeRandomNumber = fakeRandomNumber;
    }

    /**
     *
     * @return Numero Determinado
     */
    @Override
    public int getRandomNumber() {
        return fakeRandomNumber;
    }
}
