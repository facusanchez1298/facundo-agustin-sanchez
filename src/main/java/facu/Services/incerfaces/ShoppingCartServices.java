package facu.Services.incerfaces;

import facu.DAO.models.Product;

public interface ShoppingCartServices {
  /**
   * add a product to the shopping cart
   * @param product product to add
   * @param id_user user id from the sopping cart
   */
  void addProduct(int id_user, Product product);
  /**
   * remove a product from the shopping cart
   * @param id_product product id to remove
   * @param id_user user id from the shopping cart
   */
  void removeProduct(int id_user, int id_product);
  /**
   * save the shopping cart and empty it
   * @param id_user user id from the shopping cart
   */
  void buy(int id_user);
  /**
   * empty the shopping cart
   */
  void emptyShoppingCart(int id_user);
}
