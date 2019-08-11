package facu.controllers;

import facu.dao.models.Product;
import facu.services.incerfaces.ProductServices;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
  private final ProductServices data;

  public ProductController(ProductServices data) {
    this.data = data;
  }
  /**
   * save a new product in the data base
   * @param product the product to add
   */
  @PostMapping(value = "/products")
  public void createNewProduct(@RequestHeader("authorization") String authorization,
    @RequestBody Product product){
    data.createNewProduct(authorization, product);
  }
  /**
   * delete a product from the data base
   * @param id product id from the product to delete
   */
  @DeleteMapping(value = "/products/{id}")
  public void deleteProductById(@RequestHeader("authorization") String authorization,
    @PathVariable("id") @NotBlank int id){
    data.deleteProductById(authorization, id);
  }
  /**
   * get a individual product whit the same entered id
   * @param id product id from the product to get
   * @return the product whit the same id
   */
  @GetMapping(value = "/products/{id}")
  public Product getProductById(@RequestHeader("authorization") String authorization,
    @PathVariable("id") @NotBlank int id){
    return data.getProductById(authorization, id);
  }
  /**
   * find products by name and category
   * @param name product name
   * @param category product category
   * @return a list of product
   */
  @GetMapping(value = "/products", params = {"name", "category"})
  public List<Product> getproductsByNameAndCategory(@RequestHeader("authorization") String authorization,
    @RequestParam(value = "name") @NotBlank @NotNull String name,
    @RequestParam(value = "category") @NotBlank @NotNull String category){
    return data.findByNameAndCategory(authorization, name, category);
  }
  /**
   * find products by name and category
   * @param category product category
   * @return a list of product
   */
  @GetMapping(value = "/products", params =  "category")
  public List<Product> getproductsByCategory(@RequestHeader("authorization") String authorization,
    @RequestParam(value = "category") @NotBlank @NotNull String category){
    return data.findByCategory(authorization, category);
  }
  /**
   * find products by name and category
   * @param name product name
   * @return a list of product
   */
  @GetMapping(value = "/products", params = "name")
  public List<Product> getproductsByName(@RequestHeader("authorization") String authorization,
    @RequestParam(value = "name") @NotBlank @NotNull String name){
    return data.findByName(authorization, name);
  }
  /**
   * return all the product in the data Base
   * @return all the product in the data base
   */
  @GetMapping(value = "/products")
  public Iterable<Product> getAllProducts(@RequestHeader("authorization") String authorization){
    return data.getAllProducts(authorization);
  }
  /**
   * edit a product in the data base
   * @param id product id from the product to edit
   * @param product new data for the product
   */
  @PutMapping(value = "/products/{id}")
  public void updateProduct(@RequestHeader("authorization") String authorization,
    @PathVariable @NotBlank int id, @RequestBody Product product){
    data.updateProduct(authorization, id, product );
  }
}
