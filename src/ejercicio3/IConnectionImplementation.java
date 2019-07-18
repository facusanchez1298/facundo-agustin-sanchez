package ejercicio3;

public class ImplementacionIConnection implements IConnection {


    @Override
    public void conectar(Connection connection) {
        connection.setConnect(true);
    }

    @Override
    public void desconectar(Connection connection) {
        connection.setConnect(false);
    }
}
