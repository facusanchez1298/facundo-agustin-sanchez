package facu.excepciones.Classes;

public class UserNotValidException extends RuntimeException {

  public UserNotValidException(String message) {
    super(message);
  }
}
