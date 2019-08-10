package facu.services.implementation;

import facu.dao.interfaces.DaoProduct;
import facu.dao.models.Product;
import facu.excepciones.ProductNullException;
import facu.services.incerfaces.ProductServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServicesImp implements ProductServices {
  @Autowired
  private DaoProduct data;
  /**
   * save a new product in the data base
   * @param product new product to add
   */
  @Override
  public void createNewProduct(Product product) {
    if (product == null) throw new ProductNullException("the product is not valid");
    data.save(product);
  }
  /**
   * save a new product in the data base
   * @param name product name
   * @param price product price
   * @param description product description
   */
  @Override
  public void createNewProduct(String name, float price, String description) {
    Product product = new Product(name, price, description);
    data.save(product);
  }
  /**
   * delete a product to the data base
   * @param id the product id for delete
   */
  @Override
  public void deleteProductById(int id) {
    data.deleteById(id);
  }
  /**
   * edit a product in the data base
   * @param id product id
   * @param name new product name
   * @param price new product price
   * @param description new product description
   */
  @Override
  public void updateProduct(int id, String name, float price, String description) {
    Product product = data.findById(id).get();
    if(product == null) throw new ProductNullException("product is not exists");
    else {
      product.setDescription(description);
      product.setName(name);
      product.setPrice(price);
      data.save(product);
    }
  }
  /**
   * return a individual product
   * @param id product id
   * @return a product whit the same id
   */
  @Override
  public Product getProductById(int id) {
     Product product = data.findById(id).get();
     if (product != null) return product;
     else throw  new ProductNullException("the product id not exist");
  }
  /**
   * get all the product in the data base
   * @return
   */
  @Override
  public Iterable<Product> getAllProducts() {
    Iterable<Product> products = data.findAll();
    if(products != null) return products;
    else throw new ProductNullException("you don't have products");
  }
  /**
   * edit a product in the data base
   * @param id product id from the product to edit
   * @param product new data for this product
   */
  @Override
  public void updateProduct(int id, Product product) {
    if(product == null) throw new ProductNullException("the product entered is not valid");
    Product dbProduct = data.getOne(id);
    if(product != null){
      product.setId(id);
      dbProduct = product;
      data.save(dbProduct);
    }
    throw new ProductNullException("the id entered is not valid");
  }
  /**
   * return a product list with this mame and category
   * @param name product name to search
   * @param category product category to search
   * @return a product list with this mame and category
   */
  @Override
  public List<Product> findByNameAndCategory(String name, String category) {
    return data.findByNameAndCategory(name,category);
  }
  /**
   * return a product list with the entered name
   * @param name product name from the product to search
   * @return a product list with the entered name
   */
  @Override
  public List<Product> findByName(String name) {
    return data.findByName(name);
  }
  /**
   * return a product list with the entered category
   * @param category product category from the product to search
   * @return a product list with the entered category
   */
  @Override
  public List<Product> findByCategory(String category) {
    return data.findByCategory(category);
  }


}
