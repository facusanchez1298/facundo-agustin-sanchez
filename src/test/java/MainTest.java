import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;



public class MainTest {


    @Test
    public void sumar()
    {
       int resultado = Main.suma(1,2);
       int esperado = 3;

       assertEquals(esperado,resultado);
    }
}
