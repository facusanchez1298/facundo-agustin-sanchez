package DataBase;

import java.util.ArrayList;
/**
 *  
 */
public class ShoppingCart {
  private  ArrayList<Product> shoopingCart = new ArrayList<Product>();
  private boolean state = false;

  public ArrayList<Product> getShoopingCart() {
    return shoopingCart;
  }

  public boolean isState() {
    return state;
  }

  public void setState(boolean state) {
    this.state = state;
  }



}
