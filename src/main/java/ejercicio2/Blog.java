package ejercicio2;

public class Blog {

  private  String name = "";
  private String text = "empty blog";

  public Blog(String nombre){
    this.name = nombre;
  }

  public Blog(String nombre, String texto) {
    this.name = nombre;
    this.text = texto;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}
