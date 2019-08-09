package facu.excepciones;

public class StockExistingException extends RuntimeException {

  public StockExistingException(String message){
    super(message);
  }
}
