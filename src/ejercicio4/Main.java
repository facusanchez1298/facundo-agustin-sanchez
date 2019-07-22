package ejercicio4;
import ejercicio4.ConstructoresFinales.SQLServerConnection;
import ejercicio4.Director.Connector;

public class Main {
  public static void main(String[] args) {
    SQLServerConnection SQLServerConnection = new SQLServerConnection();
    Connector connector = new Connector(SQLServerConnection);
    Connection connection = connector.connect();
    System.out.println("you are connect to: " + connection.getName());
  }
}