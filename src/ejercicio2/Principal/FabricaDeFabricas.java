package ejercicio2.Principal;

import ejercicio2.interfaz.IFabricaAbstracta;

public class FabricaDeFabricas {

    public static IFabricaAbstracta getFabrica(String fabrica){

        if(fabrica.equals("Base de datos")) return  new FabricaBD();

        return null;
    }

}
