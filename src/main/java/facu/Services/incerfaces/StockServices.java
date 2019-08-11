package facu.services.incerfaces;

import facu.dao.models.Product;
import facu.dao.models.Stock;
import java.util.List;

public interface StockServices {
  /**
   * return all products in stock
   * @return all products in stock
   */
  List<Stock> getAll(String authorization);
  /**
   * return all the available products in stock
   * @return all the available products in stock
   */
  List<Stock> getAvailables(String authorization);
  /**
   * return all the inavailable products in stock
   * @return all the inavailable products in stock
   */
  List<Stock> getInavailables(String authorization);
  /**
   * return true if the product is available
   * @param productId product to search
   * @return true if the product is available
   */
  boolean isAvailable(String authorization, int productId);
  /**
   * return true if the product is available
   * @param product product to search
   * @return true if the product is available
   */
  boolean isAvailable(String authorization, Product product);
  /**
   * return the product quantity in stock
   * @param productId product to search
   * @return the product quantity in stock
   */
  int quantityOf(String authorization, int productId);
  /**
   * return the product quantity in stock
   * @param product product to search
   * @return the product quantity in stock
   */
  int quantityOf(String authorization, Product product);
  /**
   * add a product to stock
   * @param product product to add
   */
  void addProduct(String authorization, Product product, int quantity, boolean available);
  /**
   * add a product to stock
   * @param productId product to add
   */
  void addProduct(String authorization, int productId, int quantity, boolean available);
  /**
   * change a product state from stock product
   * @param product product to disable
   * @param available product state to change
   */
  void setAvailableProduct(String authorization, Product product, boolean available);
  /**
   * change a product state from stock product
   * @param available product state to change
   * @param productId product to disable
   */
  void setAvailableProduct(String authorization, int productId, boolean available);
  /**
   * define how much product there is
   * @param product product to change the quantity
   * @param quantity product quantity
   */
  void setQuantity(String authorization, Product product, int quantity);
  /**
   * define how much product there is
   * @param productId product to change the quantity
   * @param quantity product quantity
   */
  void setQuantity(String authorization, int productId, int quantity);



}
