package DataBase;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class Order {
  ShoppingCart shoppingCarts = new ShoppingCart();
  private Date date;

  public Order(ShoppingCart shoppingCart) {
    this.shoppingCarts = shoppingCart;
    this.date = new Date();
  }

  public ShoppingCart getShoppingCarts() {
    return shoppingCarts;
  }

  public void setShoppingCarts(ShoppingCart shoppingCarts) {
    this.shoppingCarts = shoppingCarts;
  }


}
