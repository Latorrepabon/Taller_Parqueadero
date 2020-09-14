package com.unicauca.tallerparqueadero.service;

import com.unicauca.tallerparqueadero.domain.access.IIngresoRepository;
import com.unicauca.tallerparqueadero.domain.Ingreso;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Libardo, Julio, Alejandro Latorre
 */
public class Service {

    private IIngresoRepository repository;

    /**
     * Inyección de dependencias en el constructor. Ya no conviene que el mismo
     * servicio cree un repositorio concreto
     *
     * @param repository una clase hija de IIngresoRepository
     */
    public Service(IIngresoRepository repository) {
        this.repository = repository;
    }

    /**
     * Guarda un "Ingreso" en el repositorio
     *
     * @param newIngreso
     * @return True si se puede registrar el ingreso en la BDD, False de lo
     * contrario
     *
     */
    public boolean saveIngreso(Ingreso newIngreso) {

        //Validate product
        if (newIngreso == null || newIngreso.getIngresoId() < 0
                || newIngreso.getTipoVehiculo().toString().isBlank() || newIngreso.getTiempo() <= 0 || newIngreso.getTarifa() <= 0) {
            return false;
        }

        repository.save(newIngreso);
        return true;

    }

    public List<Ingreso> listIngresos() {
        List<Ingreso> Ingresos = new ArrayList<>();
        Ingresos = repository.list();;

        return Ingresos;
    }

}
