package ejercicio1;
  /**
   * create a connection whit the singleton patterns
   * @autor facundo sanchez
   * @version  1.0
   */
public class SingletonConnection {
  private String url;
  private static Connection connection;
  /**
     * empty private builder
     * @param url andres for connect
     */
  private  SingletonConnection(String url){
    this.url = url;
  }
  /**
     *private class to have the singletonConnection object
     */
  private static class Connection{
      static SingletonConnection singletonConnection;
      /**
       *
       * @param url andres for connect
       */
      private Connection(String url){
        singletonConnection = new SingletonConnection(url);
      }
    }
  /** return a SingletonConnection object
     * @param url the connection string
     * @return  SingletonConnection object
     */
  public static SingletonConnection connectTo(String url){
      System.out.println("you are connected to: " + url);
      return connection.singletonConnection;
    }
  /** return a SingletonConnection object
     * @param url the connection string
     * @return  SingletonConnection object
     */
  public void setUrl(String url){
      this.url = url;
    }
}
