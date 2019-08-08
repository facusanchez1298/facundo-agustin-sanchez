package facu.Services.incerfaces;

import facu.DAO.tables.Product;

public interface ShoppingCartServices {
  /**
   * add a product to the shopping cart
   * @param product product to add
   */
  void addProduct(Product product);
  /**
   * remove a product from the shopping cart
   * @param id product id to remove
   */
  void removeProduct(int id);
  /**
   * save the shopping cart and empty it
   */
  void buy();
}
