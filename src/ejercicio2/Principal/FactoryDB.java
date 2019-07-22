package ejercicio2.Principal;

import ejercicio2.Implementacion.BD_MySQL;
import ejercicio2.Implementacion.BD_SQLServer;
import ejercicio2.interfaz.IConnectDB;
import ejercicio2.interfaz.IAbstractFactory;

/**
 * generate a connect object
 * @autor facundo sanchez
 * @version 1.0
 */
public class FactoryDB implements IAbstractFactory {
  IAbstractFactory abstractFactory;
  /**
   * generate a data base from a specific type
   * @param db type of data base
   * @return a IConnectDB object
   */
  @Override
  public IConnectDB getDataBase(String db) {
    if(db.equals("MySQL")) return new BD_MySQL();
    else if(db.equals(("SQL Server"))) return new BD_SQLServer();
    else return null;
  }
}
