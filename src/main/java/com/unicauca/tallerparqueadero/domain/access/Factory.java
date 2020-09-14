package com.unicauca.tallerparqueadero.domain.access;

import com.unicauca.tallerparqueadero.domain.*;

import java.util.EnumMap;
import java.util.Map;

/**
 * Fábrica que utiliza el patrón de diseño Singleton
 *
 * @author Libardo, Julio, Alejandro Latorre Pabón
 */
public class Factory {

    private Map<AutoEnum, CalcularTarifa> deliveryDictionary;

    // Singleton
    private static Factory instance;

    private Factory(IRandomNumberGenerator g) {
        deliveryDictionary = new EnumMap<>(AutoEnum.class);
        deliveryDictionary.put(AutoEnum.CAMION, new TarifaCamion(g));
        deliveryDictionary.put(AutoEnum.CARRO, new TarifaCarro());
        deliveryDictionary.put(AutoEnum.MOTO, new TarifaMoto());
        // Si se requie otro vehículo, se abre un registro en este diccionario
        // No se viola el principio porque este este modulo no está pensado
        // para que sea estable.
    }

    /**
     * Devuelve la instancia de la clase
     *
     * @return instancia unica de la la fábrica
     */
    public static Factory getInstance() {
        if (instance == null) {
            instance = new Factory(new RandomNumberGenerator());
        }
        return instance;
    }

    /**
     * Para un Vehiculo determina la clase que se encarga de calcular la tarifa
     * del parqueadero envío.
     *
     * @param vehiculo
     * @return
     */
    public CalcularTarifa getVehiculo(AutoEnum vehiculo) {

        CalcularTarifa result = null;

        if (deliveryDictionary.containsKey(vehiculo)) {
            result = deliveryDictionary.get(vehiculo);
        }

        return result;

    }

    /**
     * Método que crea una instancia concreta de la jerarquia IProductRepository
     *
     * @param type cadena que indica qué tipo de clase hija debe instanciar
     * @return una clase hija de la abstracción IProductRepository
     */
    public IIngresoRepository getRepository(String type) {

        IIngresoRepository result = null;

        switch (type) {
            case "default":
                result = new IngresoRepository();
                break;
        }

        return result;

    }
}
