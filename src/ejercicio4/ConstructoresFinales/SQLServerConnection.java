package ejercicio4.ConstructoresFinales;

import ejercicio4.AbstractBuilding;
import ejercicio4.Connection;

public class SQLServerConnection extends AbstractBuilding {

  /**
   * builder
   */
  public SQLServerConnection(){
    super.connection = new Connection();
  }
  /**
   * change the atribute name to 'sqlserver'
   * @return
   */
  @Override
  public Connection connectTo() {
    connection.setName("SQLServer");
    return connection;
  }
}
