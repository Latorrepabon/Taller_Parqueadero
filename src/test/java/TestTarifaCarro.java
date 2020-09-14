
import java.text.ParseException;
import org.junit.Test;
import com.unicauca.tallerparqueadero.domain.TarifaCarro;
import static org.junit.Assert.*;

/**
 * TestClass que prueba la clase TarifaCarro
 *
 * @author Alejandro Latorre Pabón
 */
public class TestTarifaCarro {

    TarifaCarro tarifaCarro = new TarifaCarro();

    /**
     * Test para comprobar si Calcular tarifa está calculando correctamente
     * cuando no es necesario redondear
     *
     * @throws ParseException
     */
    @Test
    public void testCarroRedondeo() throws ParseException {
        System.out.println("Carro Con redondeo");
        int precio = tarifaCarro.calcularTarifa(80);
        assertEquals(2400, precio);
    }

    /**
     * Test para comprobar si Calcular tarifa está calculando correctamente
     * cuando el tiempo es menor a una hora
     *
     * @throws ParseException
     */
    @Test
    public void testCarroMenosTiempo() throws ParseException {
        System.out.println("Carro menos de 60 minutos");
        int precio = tarifaCarro.calcularTarifa(10);
        assertEquals(2000, precio);
    }

    /**
     * Test para comprobar si Calcular tarifa está calculando correctamente
     * cuando no es necesario redondear
     *
     * @throws ParseException
     */
    public void testCarroNoRedondeo() throws ParseException {
        System.out.println("Carro sin redondeo");
        int precio = tarifaCarro.calcularTarifa(120);
        assertEquals(3000, precio);
    }
}
