package ejercicio2.Implementacion;

import ejercicio2.interfaz.IConnectDB;

/**
 * class to connect to sql server
 * @autor facundo sanchez
 * @version 1.0
 */
public class BD_SQLServer implements IConnectDB {
  /**
   * start the connection to sql server data base
   */
  @Override
  public void connect() {
    System.out.println("Connecting to sql server");
  }
  /**
   * close the connection to sql server data base
   */
  @Override
  public void disconnect() {
    System.out.println("Disconnecting to sql server");
  }
}
