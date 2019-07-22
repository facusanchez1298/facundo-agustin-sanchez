package ejercicio1;

/**
 * @autor facundo sanchez
 * @version 1.0
 */
public class Main {
  static String url = "www.basededatos.com";

  public static void main(String[] args) {
    SingletonConnection connection = SingletonConnection.connectTo(url);
    connection = SingletonConnection.connectTo(url);
  }
}
