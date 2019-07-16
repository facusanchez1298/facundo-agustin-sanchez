package ejercicio3;

public class ImplementacionIConexion implements  IConexion {


    @Override
    public void conectar(Conexion conexion) {
        conexion.setConectado(true);
    }

    @Override
    public void desconectar(Conexion conexion) {
        conexion.setConectado(false);
    }
}
