package ejercicio3;

/**
 * @author facundo sanchez
 * @version 1.0
 */
public class ProxyConnection implements IConnection {
  private IConnectionImplementation connection;
  /**
   * start a connection to database
   * @param connection database to connect
   */
  @Override
  public void connect(Connection connection)
  {
    if(this.connection == null)
    {
      this.connection = new IConnectionImplementation();
    }
    this.connection.connect(connection);
  }
  /**
   * stop a connection to data base
   * @param connection database to disconnect
   */
  @Override
  public void disconnect(Connection connection)
  {
    if(this.connection == null)
    {
      this.connection = new IConnectionImplementation();
    }
    this.connection.connect(connection);
  }
}
