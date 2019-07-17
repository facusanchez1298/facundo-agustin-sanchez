package ejercicio1;

public class ConexionSingleton {

    private String srl;
    private static ConexionSingleton conexion;


    private ConexionSingleton(String srl){
        srl = srl;
    }

    public static ConexionSingleton Conectar(String srl){
        if(conexion == null){

            System.out.println("conectando");
            conexion = new ConexionSingleton(srl);
            return conexion;
        }

        System.out.println("ya estabas conectado");
        return conexion;
    }

}
