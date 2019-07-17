package ejercicio3;

public class ConexionProxy implements IConexion {

    private ImplementacionIConexion connection;

    @Override
    public void conectar(Conexion conexion)
    {
        if(connection == null)
        {
            connection = new ImplementacionIConexion();
        }
        connection.conectar(conexion);
    }

    @Override
    public void desconectar(Conexion conexion)
    {
        if(connection == null)
        {
            connection = new ImplementacionIConexion();
        }
        connection.conectar(conexion);
    }
}
