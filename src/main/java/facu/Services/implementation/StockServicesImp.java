package facu.services.implementation;

import facu.dao.interfaces.DaoProduct;
import facu.dao.interfaces.DaoStock;
import facu.dao.models.Product;
import facu.dao.models.Stock;
import facu.excepciones.ExceptionController;
import facu.services.incerfaces.LoginServices;
import facu.services.incerfaces.StockServices;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class StockServicesImp implements StockServices {
  private final DaoStock dbStock;
  private final DaoProduct dbProduct;
  private final LoginServices dbLogin;
  private final ExceptionController controller;

  public StockServicesImp(DaoStock data, DaoProduct dbProduct,
    LoginServices dbLogin, ExceptionController controller) {
    this.dbStock = data;
    this.dbProduct = dbProduct;
    this.dbLogin = dbLogin;
    this.controller = controller;
  }
  /**
   * return all products in stock
   * @return all products in stock
   */
  @Override
  public List<Stock> getAll(String authorization ) {
    controller.correctAuthorization(authorization);
    return dbStock.findAll();
  }
  /**
   * return all the available products in stock
   * @return all the available products in stock
   */
  @Override
  public List<Stock> getAvailables(String authorization) {
    controller.correctAuthorization(authorization);
    return dbStock.findByAvailable(true);
  }
  /**
   * return all the inavailable products in stock
   * @return all the inavailable products in stock
   */
  @Override
  public List<Stock> getInavailables(String authorization) {
    controller.correctAuthorization(authorization);
    return dbStock.findByAvailable(false);
  }
  /**
   * return true if the product is available
   * @param productId product to search
   * @return true if the product is available
   */
  @Override
  public boolean isAvailable(String authorization, int productId) {
    controller.correctAuthorization(authorization);
    Stock stock = dbStock.findByProductId(productId);
    controller.correctStock(stock);
    return stock.isAvailable();
  }
  /**
   * return true if the product is available
   * @param product product to search
   * @return true if the product is available
   */
  @Override
  public boolean isAvailable(String authorization, Product product) {
    controller.correctAuthorization(authorization);
    controller.correctProduct(product);
    Stock stock = dbStock.findByProduct(product);
    controller.correctStock(stock);
    return stock.isAvailable();
  }
  /**
   * return the product quantity in stock
   * @param productId product to search
   * @return the product quantity in stock
   */
  @Override
  public int quantityOf(String authorization, int productId) {
    controller.correctAuthorization(authorization);
    Stock stock = dbStock.findByProductId(productId);
    controller.correctStock(stock);
    return stock.getQuantity();
  }
  /**
   * return the product quantity in stock
   * @param product product to search
   * @return the product quantity in stock
   */
  @Override
  public int quantityOf(String authorization, Product product) {
    controller.correctAuthorization(authorization);
    controller.correctProduct(product);
    Stock stock = dbStock.findByProduct(product);
    controller.correctStock(stock);
    return stock.getQuantity();
  }
  /**
   * add a product to stock
   * @param product product to add
   * @param quantity product quantity
   * @param available is available?
   */
  @Override
  public void addProduct(String authorization, Product product, int quantity, boolean available) {
    controller.correctAuthorization(authorization);
    controller.correctQuantity(quantity);
    controller.correctProduct(product);
    Stock stock = dbStock.findByProduct(product);
    controller.correctStock(stock);
    dbStock.save(new Stock(product, quantity, available));
  }
  /**
   * add a product to stock
   * @param productId product to add
   * @param quantity product quantity
   * @param available is available?
   */
  @Override
  public void addProduct(String authorization, int productId, int quantity, boolean available) {
    controller.correctAuthorization(authorization);
    controller.correctQuantity(quantity);
    Stock stock = dbStock.findByProductId(productId);
    controller.correctStock(stock);
    Product product = dbProduct.findById(productId).get();
    controller.correctProduct(product);
    dbStock.save(new Stock(product, quantity, available));
  }
  /**
   * change a product state from stock product
   * @param product product to disable
   * @param available product state to change
   */
  @Override
  public void setAvailableProduct(String authorization, Product product, boolean available) {
    controller.correctAuthorization(authorization);
    controller.correctProduct(product);
    Stock stock = dbStock.findByProduct(product);
    controller.correctStock(stock);
    stock.setAvailable(available);
  }
  /**
   * change a product state from stock product
   * @param available product state to change
   * @param productId product to disable
   */
  @Override
  public void setAvailableProduct(String authorization, int productId, boolean available) {
    controller.correctAuthorization(authorization);
    Stock stock = dbStock.findByProductId(productId);
    controller.correctStock(stock);
    stock.setAvailable(available);
  }
  /**
   * define how much product there is
   * @param product product to change the quantity
   * @param quantity product quantity
   */
  @Override
  public void setQuantity(String authorization, Product product, int quantity) {
    controller.correctAuthorization(authorization);
    controller.correctQuantity(quantity);
    controller.correctProduct(product);
    Stock stock = dbStock.findByProduct(product);
    controller.correctStock(stock);
    stock.setQuantity(quantity);
  }
  /**
   * define how much product there is
   * @param productId product to change the quantity
   * @param quantity product quantity
   */
  @Override
  public void setQuantity(String authorization, int productId, int quantity) {
    controller.correctAuthorization(authorization);
    Stock stock = dbStock.findByProductId(productId);
    controller.correctQuantity(quantity);
    controller.correctStock(stock);
    stock.setQuantity(quantity);
  }
}
