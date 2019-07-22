package ejercicio2.Implementacion;

import ejercicio2.interfaz.IConnectDB;

/**
 * class to connect to myql
 * @autor facundo sanchez
 * @version 1.0
 */
public class BD_MySQL implements IConnectDB {
  /**
   * start the connection to mysql data base
   */
  @Override
  public void connect() {
    System.out.println("Connecting to MySQLr");
  }
  /**
   * close the connection to mysql data base
   */
  @Override
  public void disconnect() {
    System.out.println("Disconnecting to MySQL");
  }
}
