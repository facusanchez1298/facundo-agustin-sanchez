package ejercicio3;

/**
 * have the function of conect and disconect a object to data base
 * @autor facundo sanchez
 * @version 1.0
 */
public interface IConnection {
  /**
   *start the connection to the data base
   *@param connection database to connect
   */
  void connect(Connection connection);
  /**
   *end the connection to the data base
   * @param connection database to disconnect
   */
  void disconnect(Connection connection);
}
