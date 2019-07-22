package ejercicio2.Principal;

import ejercicio2.interfaz.IAbstractFactory;

/**
 * create a factories factory
 * @autor facundo sanchez
 * @version 1.0
 */
public class FactoriesFactory {
  /**
   *
   * @param factory
   * @return
   */
  public static IAbstractFactory getFabrica(String factory){
    if(factory.equals("Data Base")) return  new FactoryDB();
    return null;
  }
}
