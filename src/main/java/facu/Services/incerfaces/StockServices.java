package facu.services.incerfaces;

import facu.dao.models.Product;
import facu.dao.models.Stock;
import java.util.List;

public interface StockServices {
  /**
   * return all products in stock
   * @return all products in stock
   */
  List<Stock> getAll();
  /**
   * return all the available products in stock
   * @return all the available products in stock
   */
  List<Stock> getAvailables();
  /**
   * return all the inavailable products in stock
   * @return all the inavailable products in stock
   */
  List<Stock> getInavailables();
  /**
   * return true if the product is available
   * @param productId product to search
   * @return true if the product is available
   */
  boolean isAvailable(int productId);
  /**
   * return true if the product is available
   * @param product product to search
   * @return true if the product is available
   */
  boolean isAvailable(Product product);
  /**
   * return the product quantity in stock
   * @param productId product to search
   * @return the product quantity in stock
   */
  int QuantityOf(int productId);
  /**
   * return the product quantity in stock
   * @param product product to search
   * @return the product quantity in stock
   */
  int QuantityOf(Product product);
  /**
   * add a product to stock
   * @param product product to add
   */
  void addProduct(Product product, int quantity, boolean available);
  /**
   * add a product to stock
   * @param productId product to add
   */
  void addProduct(int productId, int quantity, boolean available);
  /**
   * change a product state from stock product
   * @param product product to disable
   * @param available product state to change
   */
  void disableProduct(Product product, boolean available);
  /**
   * change a product state from stock product
   * @param available product state to change
   * @param productId product to disable
   */
  void disableProduct(int productId, boolean available);
  /**
   * define how much product there is
   * @param product product to change the quantity
   * @param quantity product quantity
   */
  void defineQuantity(Product product, int quantity);
  /**
   * define how much product there is
   * @param productId product to change the quantity
   * @param quantity product quantity
   */
  void defineQuantity(int productId, int quantity);



}
