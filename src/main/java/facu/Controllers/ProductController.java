package facu.controllers;

import facu.dao.models.Product;
import facu.services.incerfaces.ProductServices;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
    return data.getProductById(id);
  }
  /**
   * find products by name and category
   * @param name product name
   * @param category product category
   * @return a list of product
   */
  @GetMapping(value = "/products", params = {"name", "category"})
  public List<Product> getproductsByNameAndCategory(@RequestParam(value = "name") @NotBlank @NotNull String name,
    @RequestParam(value = "category") @NotBlank @NotNull String category){
    return data.findByNameAndCategory(name, category);
  }
  /**
   * find products by name and category
   * @param category product category
   * @return a list of product
   */
  @GetMapping(value = "/products", params =  "category")
  public List<Product> getproductsByCategory(@RequestParam(value = "category") @NotBlank @NotNull String category){
    return data.findByCategory(category);
  }
  /**
   * find products by name and category
   * @param name product name
   * @return a list of product
   */
  @GetMapping(value = "/products", params = "name")
  public List<Product> getproductsByName(@RequestParam(value = "name") @NotBlank @NotNull String name){
    return data.findByName(name);
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
    data.updateProduct(id, product );
  }
}
