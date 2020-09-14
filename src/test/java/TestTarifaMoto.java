
import java.text.ParseException;
import org.junit.Test;
import com.unicauca.tallerparqueadero.domain.TarifaMoto;
import static org.junit.Assert.*;

/**
 * TestClass que prueba la clase TarifaMoto
 *
 * @author Alejandro Latorre Pabón
 */
public class TestTarifaMoto {

    TarifaMoto tarifaMoto = new TarifaMoto();

    /**
     * Test para comprobar si Calcular tarifa está calculando correctamente
     * cuando se necesita redondear
     *
     * @throws ParseException
     */
    @Test
    public void testMotoRedondeo() throws ParseException {
        System.out.println("Moto Con redondeo");
        int precio = tarifaMoto.calcularTarifa(80);
        assertEquals(1200, precio);
    }

    /**
     * Test para comprobar si Calcular tarifa está calculando correctamente
     * cuando transcurre menos de un día
     *
     * @throws ParseException
     */
    @Test
    public void testMotoMenosTiempo() throws ParseException {
        System.out.println("Moto menos de 60 minutos");
        int precio = tarifaMoto.calcularTarifa(10);
        assertEquals(1000, precio);
    }

    /**
     * Test para comprobar si Calcular tarifa está calculando correctamente
     * cuando NO es necesario redondear
     *
     * @throws ParseException
     */
    @Test
    public void testMotoNoRedondeo() throws ParseException {
        System.out.println("Moto sin redondeo");
        int precio = tarifaMoto.calcularTarifa(120);
        assertEquals(1500, precio);
    }
}
