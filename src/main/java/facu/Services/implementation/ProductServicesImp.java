package facu.Services.implementation;

import facu.DAO.interfaces.DaoProduct;
import facu.DAO.tables.Product;
import facu.Services.incerfaces.ProductServices;
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
    if (product == null) throw new RuntimeException("the product is not valid");
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
    if(product == null) throw new RuntimeException("product id is not exists");
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
     else throw  new RuntimeException("the product id not exist");
  }
  /**
   * get all the product in the data base
   * @return
   */
  @Override
  public Iterable<Product> getAllProducts() {
    Iterable<Product> products = data.findAll();
    if(products != null) return products;
    else throw new RuntimeException("you don't have products");
  }
  /**
   * edit a product in the data base
   * @param id product id from the product to edit
   * @param product new data for this product
   */
  @Override
  public void updateProduct(int id, Product product) {
    if(product == null) throw new RuntimeException("the product entered is not valid");
    Product dbProduct = data.getOne(id);
    if(product != null){
      product.setId(id);
      dbProduct = product;
      data.save(dbProduct);
    }
    throw new RuntimeException("the id entered is not valid");
  }
}
