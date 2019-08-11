package facu.services.incerfaces;

import facu.dao.models.Product;
import java.util.List;

public interface ShoppingCartServices {
  /**
   * return all the product in the shopping cart
   * @param id_user user id
   * @return all the product in the shopping cart
   */
  public List<Product> getProducts(String authorization, int id_user);
  /**
   * add a product to the shopping cart
   * @param product product to add
   * @param id_user user id from the sopping cart
   */
  void addProduct(String authorization, int id_user, Product product, int quantity);
  /**
   * add a product to shopping cart
   * @param id_user user id from the sopping cart
   * @param productId product to add
   */
  public void addProduct(String authorization, int id_user, int productId, int quantity);
  /**
   * remove a product from the shopping cart
   * @param id_product product id to remove
   * @param id_user user id from the shopping cart
   */
  void removeProduct(String authorization, int id_user, int id_product);
  /**
   * save the shopping cart and empty it
   * @param id_user user id from the shopping cart
   */
  void buy(String authorization, int id_user);
  /**
   * empty the shopping cart
   * @param id_user user id from the shopping cart
   */
  void emptyShoppingCart(String authorization, int id_user);
}
