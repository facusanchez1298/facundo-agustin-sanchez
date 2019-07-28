package Services;

import DataBase.Database;
import DataBase.Order;
import DataBase.Product;
import DataBase.ShoppingCart;
import java.util.stream.Stream;

public class ShoppingCartServices {
  private Database database = new Database();
  private ShoppingCart shoppingCart = new ShoppingCart();

  public void buy(){
    shoppingCart.setState(true);
    database.addOrder(new Order(shoppingCart));
    shoppingCart = new ShoppingCart();
  }

  public boolean isEmpty() {
    return shoppingCart.getShoopingCart().isEmpty();
  }

  public Stream<Product> stream() {
    return shoppingCart.getShoopingCart().stream();
  }

  public void add(Product product){
    shoppingCart.getShoopingCart().add(product);
  }
}
