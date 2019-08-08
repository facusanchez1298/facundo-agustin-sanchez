package facu.Controllers;

import facu.DAO.tables.Product;
import facu.Services.incerfaces.ProductServices;
import javax.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
  @Autowired
  private ProductServices data;
  /**
   * save a new product in the data base
   * @param product the product to add
   */
  @PostMapping(value = "/products")
  public void createNewProduct(@RequestBody Product product){
    data.createNewProduct(product);
  }
  /**
   * delete a product from the data base
   * @param id product id from the product to delete
   */
  @DeleteMapping(value = "/products/{id}")
  public void deleteProductById(@PathVariable("id") @NotBlank int id){
    data.deleteProductById(id);
  }
  /**
   * get a individual product whit the same entered id
   * @param id product id from the product to get
   * @return the product whit the same id
   */
  @GetMapping(value = "/products/{id}")
  public Product getProductById(@PathVariable("id") @NotBlank int id){
    Product product = data.getProductById(id);
    if (product != null) return product;
    throw new RuntimeException("the entered id is not valid");
  }
  /**
   * return all the product in the data Base
   * @return all the product in the data base
   */
  @GetMapping(value = "/products")
  public Iterable<Product> getAllProducts(){
    return data.getAllProducts();
  }
  /**
   * edit a product in the data base
   * @param id product id from the product to edit
   * @param product new data for the product
   */
  @PutMapping(value = "/products/{id}")
  public void updateProduct(@PathVariable @NotBlank int id, @RequestBody Product product){
    if(product == null) throw new RuntimeException("the entered product is not valid");
    data.updateProduct(id, product );
  }
}
