package DataBase;

import java.util.ArrayList;
import java.util.Comparator;

/** here we'll have the product
 * @author facundo sanchez
 * @version 1.0
 */
public class Database {
  private int index = 1;
  ArrayList<Product> stock = new ArrayList<Product>();

  /**
   * add a product to stock
   * @param name product name
   * @param price product price
   * @param quality product quality
   */
  public void AddProduct(String name, float price, int quality){
    Product product = new Product(index, name, price, quality);
    stock.add(product);
    setIndex();
  }
  /**
   * return the product stock
   * @return ArrayList<Product>
   */
  public ArrayList<Product> getProducts(){
    return stock;
  }
  /**
   * add a product to stock
   * @param name
   * @param price
   * @param quality
   * @param description
   */
  public void AddProduct(String name, float price, int quality, String description){
    Product product = new Product(index, name, price, quality, description);
    stock.add(product);
    setIndex();
  }
  /**
   * update a product
   * @param index product id
   * @param newName new product name
   * @param newPrice new product price
   */
  public void updateProduct(int index, String newName, float newPrice, int quantity, String description){
    Product toUpdate = findProduct(index);
    int id = stock.indexOf(toUpdate);
    stock.get(id).setName(newName);
    stock.get(id).setPrice(newPrice);
    stock.get(id).setQuantity(quantity);
    stock.get(id).setDescripcion(description);
  }
  /**
   * delete a product
   * @param index product index
   */
  public void dropProduct(int index){
    Product forDrop = findProduct(index);
    stock.remove(forDrop);
  }
  /**
   * set the index like the max id in the stock + 1
   * @see java.util.stream.Stream
   * @see java.util.Collection
   */
  private void setIndex(){
    index = stock.stream()
      .max(Comparator.comparing(Product::getId))
      .get()
      .getId() + 1;
  }
  /**
   * search a product for him id
   * @param index product id
   * @return
   */
  public Product findProduct(int index){
    return (Product) stock.stream() //search the index and cast
      .filter(q-> q.getId( ) == index);
  }
  /**
   * return true if not have products
   * @return boolean
   */
  public boolean isEmpty() {
    return stock.isEmpty();
  }


}
