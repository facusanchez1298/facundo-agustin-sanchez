package facu.excepciones;

public class ProductNullException extends RuntimeException {
  public ProductNullException(String message){
    super(message);
  }

  public ProductNullException(){
    super("the entered product is null");
  }
}
