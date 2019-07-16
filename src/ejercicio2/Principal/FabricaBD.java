package ejercicio2.Principal;

import ejercicio2.Implementacion.BD_MySQL;
import ejercicio2.Implementacion.BD_SQLServer;
import ejercicio2.interfaz.IConectarBD;
import ejercicio2.interfaz.IFabricaAbstracta;

public class FabricaBD implements  IFabricaAbstracta {

    IFabricaAbstracta abstractFabrica;

    @Override
    public IConectarBD getBaseDeDatos(String bd) {


        if(bd.equals("MySQL")) return new BD_MySQL();
        else if(bd.equals(("SQL Server"))) return new BD_SQLServer();
        else return null;

    }
}
