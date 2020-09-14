
import java.text.ParseException;
import org.junit.Test;
import com.unicauca.tallerparqueadero.domain.access.RandomNumberGenerator;
import static org.junit.Assert.*;

/**
 * TestClass que prueba la clase Random NumberGenerator
 *
 * @author Alejandro Latorre Pabón
 */
public class TestRandomNumberGenerator {

    /**
     * Test para comprobar si la clase Random Number produce números entre 1 y
     * 1000
     *
     * @throws ParseException
     */
    @Test
    public void testCalcularRandomNumber() throws ParseException {
        System.out.println("Camion con redondeo");
        int randomNumber = new RandomNumberGenerator().getRandomNumber();
        assertTrue(randomNumber >= 1 && randomNumber <= 1000);
    }
}
