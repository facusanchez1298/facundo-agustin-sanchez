package ejercicio2.interfaz;

/**
 * defines the behavior of factories
 * @autor facundo sanchez
 * @version 1.0
 */
public interface IAbstractFactory {
  /**
   * return a object to connect to data base
   * @param DB data base type
   * @return return a IConnectDB object
   */
  IConnectDB getDataBase(String DB);
}
