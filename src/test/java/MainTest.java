import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest {

  @Test
  public void sumTest()
  {
    int result = Main.suma(1,2);
    int expectedResult = 3;
    assertEquals(expectedResult,result);
  }
}
