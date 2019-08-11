package facu.services.implementation;

import facu.dao.interfaces.DaoProduct;
import facu.dao.models.Product;
import facu.excepciones.Classes.ProductNullException;
import facu.excepciones.ExceptionController;
import facu.services.incerfaces.LoginServices;
import facu.services.incerfaces.ProductServices;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProductServicesImp implements ProductServices {
  private final DaoProduct dbProduct;
  private final LoginServices dbLogin;
  private final ExceptionController controller;

  public ProductServicesImp(DaoProduct data, LoginServices dbLogin,
    ExceptionController controller) {
    this.dbProduct = data;
    this.dbLogin = dbLogin;
    this.controller = controller;
  }
  /**
   * save a new product in the dbProduct base
   * @param product new product to add
   */
  @Override
  public void createNewProduct(String authorization, Product product) {
    controller.correctProduct(product);
    dbProduct.save(product);
  }
  /**
   * save a new product in the dbProduct base
   * @param name product name
   * @param price product price
   * @param description product description
   */
  @Override
  public void createNewProduct(String authorization, String name, float price, String description) {
    Product product = new Product(name, price, description);
    dbProduct.save(product);
  }
  /**
   * delete a product to the dbProduct base
   * @param id the product id for delete
   */
  @Override
  public void deleteProductById(String authorization, int id) {
    dbProduct.deleteById(id);
  }
  /**
   * edit a product in the dbProduct base
   * @param id product id
   * @param name new product name
   * @param price new product price
   * @param description new product description
   */
  @Override
  public void updateProduct(String authorization, int id, String name, float price, String description) {
    Product product = dbProduct.findById(id).get();
    controller.correctProduct(product);
    product.setDescription(description);
    product.setName(name);
    product.setPrice(price);
    dbProduct.save(product);
  }
  /**
   * return a individual product
   * @param id product id
   * @return a product whit the same id
   */
  @Override
  public Product getProductById(String authorization, int id) {
     Product product = dbProduct.findById(id).get();
     controller.correctProduct(product);
     return product;
  }
  /**
   * get all the product in the dbProduct base
   * @return
   */
  @Override
  public Iterable<Product> getAllProducts(String authorization) {
    Iterable<Product> products = dbProduct.findAll();
    return products;
  }
  /**
   * edit a product in the dbProduct base
   * @param id product id from the product to edit
   * @param product new dbProduct for this product
   */
  @Override
  public void updateProduct(String authorization, int id, Product product) {
    controller.correctProduct(product);
    Product dbProduct = this.dbProduct.getOne(id);
    controller.correctProduct(product);
    product.setId(id);
    dbProduct = product;
    this.dbProduct.save(dbProduct);
  }
  /**
   * return a product list with this mame and category
   * @param name product name to search
   * @param category product category to search
   * @return a product list with this mame and category
   */
  @Override
  public List<Product> findByNameAndCategory(String authorization, String name, String category) {
    return dbProduct.findByNameAndCategory(name,category);
  }
  /**
   * return a product list with the entered name
   * @param name product name from the product to search
   * @return a product list with the entered name
   */
  @Override
  public List<Product> findByName(String authorization, String name) {
    return dbProduct.findByName(name);
  }
  /**
   * return a product list with the entered category
   * @param category product category from the product to search
   * @return a product list with the entered category
   */
  @Override
  public List<Product> findByCategory(String authorization, String category) {
    return dbProduct.findByCategory(category);
  }


}
