package Services;

import DataBase.Database;
import DataBase.Product;

public class CRUDServices {
  Database database = new Database();

  /**
   * show all the product and show a message "don't have product to show" if not have product
   */
  public void showProducts(){
    if (database.isEmpty()) {
      System.out.println("don't have product to show");
    }
    else{
      System.out.printf("%-3s %-10s %-6s %-5s\n","id", "name", "price", "quality");
    database.getProducts().stream().
      forEach(q -> System.out.printf("%-3s %-10s %-6s %-5s\n", q.getId(), q.getName(), q.getPrice(), q.getQuantity()));
    }
  }
  /**
   * save a new product without description
   * @param name product name
   * @param price product price
   * @param quality how many stock you have
   */
  public void SaveProduct(String name, float price, int quality){
    database.AddProduct(name, price, quality);
  }
  /**
   *
   * save a new product with description
   * @param name product name
   * @param price product price
   * @param quality how many stock you have
   * @param description describe the product
   */
  public void SaveProduct(String name, float price, int quality, String description){
    database.AddProduct(name, price, quality, description);
  }
  /**
   * return true if exists one product with this id
   * @param id id to search
   * @return true if exists and false if not
   */
  public boolean exist(int id){
    return database.getProducts().stream().anyMatch(q -> q.getId() == id);
  }
  /**
   * change the data int the database
   * @param index product index for product for change
   * @param name new product name
   * @param price new product price
   * @param quantity new product quantity
   * @param description new product description
   */
  public void editProduct(int index, String name, float price, int quantity, String description) {
    database.updateProduct(index,name,price,quantity,description);
  }
  /**
   * @return return true if the data base is empty
   */
  public boolean isEmtpy(){
    return database.isEmpty();
  }
  /**
   * remove a product with a same id
   * @param index product id for the product to remove
   */
  public void removeProduct(int index) {
    database.dropProduct(index);
  }
  /**
   * get a product with this index
   * @param index product index to search
   * @return a product with the same id
   */
  public Product getProduct(int index) {
    return database.findProduct(index);
  }
}
