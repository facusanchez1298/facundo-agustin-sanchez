package facu.excepciones.Classes;

public class ProductNullException extends RuntimeException {
  public ProductNullException(String message){
    super(message);
  }

  public ProductNullException(){
    super("the entered product is null");
  }
}
