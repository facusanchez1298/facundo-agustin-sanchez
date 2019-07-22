package ejercicio2.interfaz;

/**
 * have the function of conect and disconect a object to data base
 * @autor facundo sanchez
 * @version 1.0
 */
public interface IConnectDB {
  /**
   *start the connection to the data base
   */
  void connect();
  /**
   *end the connection to the data base
   */
  void disconnect();
}
