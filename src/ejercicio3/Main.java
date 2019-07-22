package ejercicio3;

public class Main {

  public static void main(String[] args) {
    Connection connection = new Connection();
    IConnection proxyConnection = new ProxyConnection();
    proxyConnection.connect(connection);
    System.out.println("stable connection = " + connection.isConnect());
  }
}
