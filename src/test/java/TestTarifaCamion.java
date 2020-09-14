
import java.text.ParseException;
import org.junit.Test;
import com.unicauca.tallerparqueadero.domain.TarifaCamion;
import com.unicauca.tallerparqueadero.domain.access.MockRandomNumberGenerator;
import static org.junit.Assert.*;

/**
 * TestClass que prueba la clase TarifaCamion
 *
 * @author Alejandro Latorre Pabón
 */
public class TestTarifaCamion {

    /**
     * Objeto de la clase "tarifaCamion" que utiliza la implementación
     * "MockRandomNumberGenerator" para fijar el valor "RandomNumber"
     */
    private TarifaCamion tarifaCamion = new TarifaCamion(new MockRandomNumberGenerator(167));

    /**
     * Test para comprobar si Calcular tarifa está redondeando correctamente
     *
     * @throws ParseException
     */
    @Test
    public void testCalcularTarifaRedondeo() throws ParseException {
        System.out.println("Camion con redondeo");
        int precio = tarifaCamion.calcularTarifa(1650);
        assertEquals(17200, precio);
    }

    /**
     * Test para comprobar si Calcular tarifa está calculando correctamente
     * cuando el tiempo es menor a un día y mayor a medio día
     *
     * @throws ParseException
     */
    @Test
    public void testCamionUnDia() throws ParseException {
        System.out.println("Camion un día");
        int precio = tarifaCamion.calcularTarifa(1000);
        assertEquals(15000, precio);
    }

    /**
     * Test para comprobar si Calcular tarifa está calculando correctamente
     * cuando el tiempo es menor a un día
     *
     * @throws ParseException
     */
    @Test
    public void testCamionMedioDia() throws ParseException {
        System.out.println("Camion medio dia");
        int precio = tarifaCamion.calcularTarifa(120);
        assertEquals(10000, precio);
    }

    /**
     * Test para comprobar si Calcular tarifa está calculando correctamente
     * cuando no es necesario redondear
     *
     * @throws ParseException
     */
    @Test
    public void testCamionSinRedondeo() throws ParseException {
        System.out.println("Camion sin redondeo");
        int precio = tarifaCamion.calcularTarifa(2640);
        assertEquals(27500, precio);
    }

    /**
     * Test para comprobar si al ganar el sorteo, la tarifa se está reduciendo a
     * cero
     *
     * @throws ParseException
     */
    @Test
    public void testCamionGanaSorteo() throws ParseException {
        System.out.println("Camion sin redondeo");
        int tarifa = tarifaCamion.calcularTarifa(1600);
        assertEquals(0, tarifa);
    }
}
