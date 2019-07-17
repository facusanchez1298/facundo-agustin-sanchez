package ejercicio3;

import ejercicio2.Principal.FabricaDeFabricas;
import ejercicio2.interfaz.IConectarBD;
import ejercicio2.interfaz.IFabricaAbstracta;

public class Main {

    public static void main(String[] args) {


        Conexion conexion = new Conexion();

        IConexion conexionProxy = new ConexionProxy();

        conexionProxy.conectar(conexion);


        System.out.println("conexion estable = " + conexion.isConectado());


    }
}
