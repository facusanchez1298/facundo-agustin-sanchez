package facu.Services.implementation;

import facu.DAO.interfaces.DaoProduct;
import facu.DAO.tables.Product;
import facu.Services.incerfaces.ProductServices;
import java.time.DayOfWeek;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.parameters.P;

public class ProductServicesImp implements ProductServices {
  @Autowired
  private DaoProduct data;

  @Override
  public void createNewProduct(String name, float price, String description) {
    Product product = new Product(name, price, description);
    data.save(product);
  }

  @Override
  public void deleteProductById(int id) {
    data.deleteById(id);
  }

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

  @Override
  public Product getProductById(int id) {
     Product product = data.findById(id).get();
     if (product != null) return product;
     else throw  new RuntimeException("the product id not exist");
  }

  @Override
  public Iterable<Product> getAllProducts() {
    Iterable<Product> products = data.findAll();
    if(products != null) return products;
    else throw new RuntimeException("you don't have products");
  }
}
