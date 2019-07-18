package ejercicio1;

public class ConexionSingleton {

    private String srl;
    private static ConexionSingleton conexion;

    //building
    private ConexionSingleton(String srl){
        srl = srl;
    }

  /**
   * return a ConexionSingleton object
   * @param url the conection string
   * @return
   */
    public static ConexionSingleton conectar(String url){
        if(conexion == null){

            System.out.println("conectando");
            conexion = new ConexionSingleton(url);
            return conexion;
        }

        System.out.println("ya estabas conectado");
        return conexion;
    }

}
