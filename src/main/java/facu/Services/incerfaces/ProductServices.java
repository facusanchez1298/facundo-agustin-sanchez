package facu.Services.incerfaces;

import facu.DAO.tables.Product;

public interface ProductServices {

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
}
