package facu.services.implementation;

import facu.dao.interfaces.DaoProduct;
import facu.dao.interfaces.DaoStock;
import facu.dao.models.Product;
import facu.dao.models.Stock;
import facu.excepciones.ProductNullException;
import facu.excepciones.StockExistingException;
import facu.excepciones.StockNullException;
import facu.services.incerfaces.StockServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockServicesImp implements StockServices {
  @Autowired
  private DaoStock data;
  @Autowired
  private DaoProduct dbProduct;
  /**
   * return all products in stock
   * @return all products in stock
   */
  @Override
  public List<Stock> getAll() {
    return data.findAll();
  }
  /**
   * return all the available products in stock
   * @return all the available products in stock
   */
  @Override
  public List<Stock> getAvailables() {
    return data.findByAvailable(true);
  }
  /**
   * return all the inavailable products in stock
   * @return all the inavailable products in stock
   */
  @Override
  public List<Stock> getInavailables() {
    return data.findByAvailable(false);
  }
  /**
   * return true if the product is available
   * @param productId product to search
   * @return true if the product is available
   */
  @Override
  public boolean isAvailable(int productId) {
    Stock stock = data.findByProductId(productId);
    if(stock == null)
      throw new StockNullException("the entered id is not valid");
    return stock.isAvailable();
  }
  /**
   * return true if the product is available
   * @param product product to search
   * @return true if the product is available
   */
  @Override
  public boolean isAvailable(Product product) {
    if(product == null)
      throw new ProductNullException("the product entered is null");
    Stock stock = data.findByProducts(product);
    if(stock == null)
      throw new StockNullException("the entered id is not valid");
    return stock.isAvailable();
  }
  /**
   * return the product quantity in stock
   * @param productId product to search
   * @return the product quantity in stock
   */
  @Override
  public int QuantityOf(int productId) {
    Stock stock = data.findByProductId(productId);
    if(stock == null)
      throw new StockNullException("the entered id is not valid");
    return stock.getQuantity();
  }
  /**
   * return the product quantity in stock
   * @param product product to search
   * @return the product quantity in stock
   */
  @Override
  public int QuantityOf(Product product) {
    if(product == null)
      throw new ProductNullException("the product entered is not valid");
    Stock stock = data.findByProducts(product);
    if(stock == null)
      throw new StockNullException("the entered id is not valid");
    return stock.getQuantity();
  }
  /**
   * add a product to stock
   * @param product product to add
   */
  @Override
  public void addProduct(Product product, int quantity, boolean available) {
    if (quantity < 0)
      throw new RuntimeException("the entered number can't be lower to 0");
    if(product == null)
      throw new ProductNullException("the product entered is not valid");
    Stock stock = data.findByProducts(product);
    if(stock != null)
      throw new StockExistingException("the entered product exists in stock");
    data.save(new Stock(product, quantity, available));
  }
  /**
   * add a product to stock
   * @param productId product to add
   */
  @Override
  public void addProduct(int productId, int quantity, boolean available) {
    if (quantity < 0)
      throw new RuntimeException("the entered number can't be lower to 0");
    Stock stock = data.findByProductId(productId);
    if(stock != null)
      throw new StockExistingException("the entered product exists in stock");
    Product product = dbProduct.findById(productId).get();
    if(product == null)
      throw new ProductNullException("the entered product id is not valid");
    data.save(new Stock(product, quantity, available));
  }
  /**
   * change a product state from stock product
   * @param product product to disable
   * @param available product state to change
   */
  @Override
  public void disableProduct(Product product, boolean available) {
    if(product == null)
      throw new ProductNullException("the product entered is null");
    Stock stock = data.findByProducts(product);
    if(stock == null)
      throw new StockNullException("the entered id is not valid");
    stock.setAvailable(available);
  }
  /**
   * change a product state from stock product
   * @param available product state to change
   * @param productId product to disable
   */
  @Override
  public void disableProduct(int productId, boolean available) {
    Stock stock = data.findByProductId(productId);
    if(stock == null)
      throw new StockNullException("the entered id is not valid");
    stock.setAvailable(available);
  }
  /**
   * define how much product there is
   * @param product product to change the quantity
   * @param quantity product quantity
   */
  @Override
  public void defineQuantity(Product product, int quantity) {
    if(product == null)
      throw new ProductNullException("the product entered is null");
    Stock stock = data.findByProducts(product);
    if(stock == null)
      throw new StockNullException("the entered id is not valid");
    if (quantity < 0)
      throw new RuntimeException("the entered number can't be lower to 0");
    stock.setQuantity(quantity);
  }
  /**
   * define how much product there is
   * @param productId product to change the quantity
   * @param quantity product quantity
   */
  @Override
  public void defineQuantity(int productId, int quantity) {
    if (quantity < 0)
      throw new RuntimeException("the entered number can't be lower to 0");
    Stock stock = data.findByProductId(productId);
    if(stock == null)
      throw new StockNullException("the entered id is not valid");
    stock.setQuantity(quantity);
  }
}
