package ejercicio2.Principal;

import ejercicio2.interfaz.IAbstractFactory;

public class FactoriesFactory {

    public static IAbstractFactory getFabrica(String fabrica){
        if(fabrica.equals("Base de datos")) return  new FactoryDB();
        return null;
    }

}
