package facu.excepciones.Classes;

public class StockExistingException extends RuntimeException {

  public StockExistingException(String message){
    super(message);
  }
}
