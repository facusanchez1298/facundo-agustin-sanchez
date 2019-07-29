package Services;

import DataBase.Database;
import DataBase.Order;
import DataBase.Product;
import DataBase.ShoppingCart;
import java.util.stream.Stream;

public class ShoppingCartServices {
  private Database database = new Database();
  private ShoppingCart shoppingCart = new ShoppingCart();
  /**
   * swich the shopping cart state to true and save it in the database
   */
  public void buy(){
    shoppingCart.setState(true);
    database.addOrder(new Order(shoppingCart));
    shoppingCart = new ShoppingCart();
  }
  /**
   * return true if the shopping cart contains not product
   * @return true if the shopping cart contains not product
   */
  public boolean isEmpty() {
    return shoppingCart.getShoopingCart().isEmpty();
  }

  public Stream<Product> stream() {
    return shoppingCart.getShoopingCart().stream();
  }
  /**
   * add a product to shopping cart
   * @param product product to be add
   */
  public void add(Product product){
    shoppingCart.getShoopingCart().add(product);
  }
}
