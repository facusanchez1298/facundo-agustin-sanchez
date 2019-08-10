package facu.excepciones;

public class EmptyShoppingCartException extends RuntimeException {

  public EmptyShoppingCartException(String message){
    super(message);
  }
}
