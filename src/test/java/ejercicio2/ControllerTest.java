package ejercicio2;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ControllerTest {

  Controller controller;

  @Before
  public void name() {
    controller = new Controller();
  }

  @Test
  public void isNumber() {
    boolean result = controller.isNumber("12");
    assertEquals(result,true);
  }
}
