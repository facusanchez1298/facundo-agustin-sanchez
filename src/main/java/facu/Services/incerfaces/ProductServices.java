package facu.services.incerfaces;

import facu.dao.models.Product;
import java.util.List;

public interface ProductServices {
  /**
   * add a new product in the data base
   * @param product new product to add
   */
  void createNewProduct(Product product);
  /**
   * create a new product in the data base
   * @param name product name
   * @param price product price
   * @param description product description
   */
  void createNewProduct(String name, float price, String description);
  /**
   * delete a product from the database
   * @param id the product id for delete
   */
  void deleteProductById(int id);
  /**
   * update a product data from the data base
   * @param id product id
   * @param name new product name
   * @param price new product price
   * @param description new product description
   */
  void updateProduct(int id, String name, float price, String description);
  /**
   * return a particular product from the data base
   * @param id product id
   * @return a product whit the id entered
   */
  Product getProductById(int id);
  /**
   * return all the product from the data base
   * @return all the product from the data base
   */
  Iterable<Product> getAllProducts();
  /**
   * edit a product in the data base
   * @param id product id from the product to edit
   * @param product new data for this product
   */
  void updateProduct(int id, Product product);
  /**
   * search for a product name like the entered and category equal the entered
   * @param name product name to search
   * @param category product category to search
   * @return a list of product whit entered name and category
   */
  List<Product> findByNameAndCategory(String name, String category);
  /**
   * find products by name
   * @param name product name from the product to search
   * @return a list of product with the same name entered
   */
  List<Product> findByName(String name);
  /**
   * find products by category
   * @param category product category from the product to search
   * @return a list of product with the same category entered
   */
  List<Product> findByCategory(String category);
}
