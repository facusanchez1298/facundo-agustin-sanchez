package ejercicio4;

public abstract class AbstractConstructor {

    protected Conexion conexion;

    public Conexion  getConexion(){
        return  conexion;
    }

    public abstract Conexion conectar();


}
