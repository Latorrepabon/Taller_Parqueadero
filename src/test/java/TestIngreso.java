
import java.text.ParseException;
import org.junit.Test;
import com.unicauca.tallerparqueadero.domain.Ingreso;
import com.unicauca.tallerparqueadero.domain.AutoEnum;
import static org.junit.Assert.*;

/**
 * TestClass que prueba la clase Ingreso
 *
 * @author Alejandro Latorre Pabón
 */
public class TestIngreso {

    /**
     * Test para comprobar si la clase ingreso ingresa de manera correcta un
     * camión con los datos dados
     *
     * @throws ParseException
     */
    @Test

    public void testIngresoCamion() throws ParseException {
        System.out.println("Ingreso Camión");
        Ingreso ingreso = new Ingreso(1, AutoEnum.CAMION, 1600);

        int id = ingreso.getIngresoId();
        AutoEnum tipoVehiculo = ingreso.getTipoVehiculo();
        int tiempo = ingreso.getTiempo();
        int tarifa = ingreso.getTarifa();

        assertEquals(1, id);
        assertEquals(AutoEnum.CAMION, tipoVehiculo);
        assertEquals(1600, tiempo);
        assertEquals(16700, tarifa);
    }

    /**
     * Test para comprobar si la clase ingreso ingresa de manera correcta un
     * camión con los datos dados
     *
     * @throws ParseException
     */
    @Test
    public void testIngresoCarro() throws ParseException {
        System.out.println("Ingreso Carro");
        Ingreso ingreso = new Ingreso(2, AutoEnum.CARRO, 80);

        int id = ingreso.getIngresoId();
        AutoEnum tipoVehiculo = ingreso.getTipoVehiculo();
        int tiempo = ingreso.getTiempo();
        int tarifa = ingreso.getTarifa();

        assertEquals(2, id);
        assertEquals(AutoEnum.CARRO, tipoVehiculo);
        assertEquals(80, tiempo);
        assertEquals(2400, tarifa);
    }

    /**
     * Test para comprobar si la clase ingreso ingresa de manera correcta un
     * camión con los datos dados
     *
     * @throws ParseException
     */
    @Test
    public void testIngresoMoto() throws ParseException {
        System.out.println("Ingreso MOTO");
        Ingreso ingreso = new Ingreso(3, AutoEnum.MOTO, 80);

        int id = ingreso.getIngresoId();
        AutoEnum tipoVehiculo = ingreso.getTipoVehiculo();
        int tiempo = ingreso.getTiempo();
        int tarifa = ingreso.getTarifa();

        assertEquals(3, id);
        assertEquals(AutoEnum.MOTO, tipoVehiculo);
        assertEquals(80, tiempo);
        assertEquals(1200, tarifa);
    }

}
