package facu.excepciones.Classes;

public class EmptyShoppingCartException extends RuntimeException {

  public EmptyShoppingCartException(String message){
    super(message);
  }
}
