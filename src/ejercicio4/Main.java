package ejercicio4;
import ejercicio4.ConstructoresFinales.ConexionSQLServer;
import ejercicio4.Director.Conector;

import javax.jws.Oneway;

public class Main {

    public static void main(String[] args) {


        //implementacion
        ConexionSQLServer conexionSQLServer = new ConexionSQLServer();

        Conector conector = new Conector(conexionSQLServer);

        Conexion conexion = conector.conectarse();

        System.out.println("Estas conectado a: " + conexion.getNombre());



    }
}
