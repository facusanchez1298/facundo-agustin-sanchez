package ejercicio1;

public class Main {

    public static void main(String[] args) {

        ConexionSingleton conexion = ConexionSingleton.Conectar("www.basededatos.com");


        ConexionSingleton.Conectar("www.basededatos.com");
    }
}
