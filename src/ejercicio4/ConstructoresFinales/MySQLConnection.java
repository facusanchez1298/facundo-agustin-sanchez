package ejercicio4.ConstructoresFinales;

import ejercicio4.AbstractBuilding;
import ejercicio4.Connection;

public class MySQLConnection extends AbstractBuilding {

  /**
   * builder
   */
  public MySQLConnection(){
    super.connection = new Connection();
  }
  /**
   * change the atribute name to 'mysql'
   * @return
   */
  @Override
  public Connection connectTo() {
    connection.setName("MySQL");
    return connection;
  }

}
