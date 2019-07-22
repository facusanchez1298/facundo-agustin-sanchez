package ejercicio2.Principal;

import ejercicio2.interfaz.IConnectDB;
import ejercicio2.interfaz.IAbstractFactory;

/**
 * @autor facundo sanchez
 * @version 1.0
 */
public class Main {

  public static void main(String[] args) {
    IAbstractFactory factoriesFactory;
    IConnectDB factoryDB;
    factoriesFactory = FactoriesFactory.getFabrica("Data Base");
    factoryDB = factoriesFactory.getDataBase("MySQL");
    factoryDB.connect();
    factoryDB.disconnect();
    factoriesFactory = FactoriesFactory.getFabrica("Base de datos");
    factoryDB = factoriesFactory.getDataBase("SQL Server");
    factoryDB.connect();
    factoryDB.disconnect();
  }
}
