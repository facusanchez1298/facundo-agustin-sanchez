package DataBase;

public class Product {
  private int id;
  private String name;
  private float price;
  private int quantity;
  private String descripcion;

  public Product(int id, String name, float price, int quantity, String descripcion) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.quantity = quantity;
    this.descripcion = descripcion;
  }

  public Product(int id, String name, float price, int quantity) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.quantity = quantity;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public float getPrice() {
    return price;
  }

  public void setPrice(float price) {
    this.price = price;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public int getId(Product product, Product product1) {
    return product.getId(  ) > product1.getId( )? product.getId( ) : product1.getId( );
  }

  public void AddOne(){
    this.quantity += 1;
  }

  public void removeOne() throws Exception {
    if(quantity > 0) this.quantity -= 1;
    else throw new Exception("you don't have " + this.name);
  }
}
