package ejercicio2.Principal;

import ejercicio2.interfaz.IConectarBD;
import ejercicio2.interfaz.IFabricaAbstracta;

public class Main {

    public static void main(String[] args) {


        IFabricaAbstracta fabricaDeFabricas;
        IConectarBD fabricaBD;

        fabricaDeFabricas = FabricaDeFabricas.getFabrica("Base de datos");
        fabricaBD = fabricaDeFabricas.getBaseDeDatos("MySQL");


        fabricaBD.conectar();
        fabricaBD.desconectar();


        fabricaDeFabricas = FabricaDeFabricas.getFabrica("Base de datos");
        fabricaBD = fabricaDeFabricas.getBaseDeDatos("SQL Server");


        fabricaBD.conectar();
        fabricaBD.desconectar();
    }
}
