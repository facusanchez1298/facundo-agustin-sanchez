package ejercicio4;

public abstract class AbstractBuilding {
  protected Connection connection;
  /**
   * return this.connection
   * @return Connection
   */
  public Connection getConnection(){
    return connection;
  }
  /**
   * return a connection
   * @return Connection
   */
   public abstract Connection connectTo();
}
