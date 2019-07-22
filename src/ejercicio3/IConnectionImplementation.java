package ejercicio3;

/**
 * controller the connection to data base
 */
public class IConnectionImplementation implements IConnection {
  /**
   * connect to data base
   * @param connection database to connect
   */
  @Override
  public void connect(Connection connection) {
    connection.setConnect(true);
  }
  /**
   * disconnect to data base
   * @param connection database to disconnect
   */
  @Override
  public void disconnect(Connection connection) {
    connection.setConnect(false);
  }
}
