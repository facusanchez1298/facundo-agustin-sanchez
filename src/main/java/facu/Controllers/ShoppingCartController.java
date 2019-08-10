package facu.controllers;

import facu.dao.models.Product;
import facu.services.implementation.ShoppingCartServicesImp;
import java.util.List;
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
public class ShoppingCartController {
  @Autowired
  ShoppingCartServicesImp dbShoppigCart;
  /**
   * return all the product in the user's shopping cart
   * @param userId user id
   * @return
   */
  @GetMapping(value = "/users/{id}/shoppingCart")
  public List<Product> getProducts(@PathVariable(value = "id") int userId){
    return dbShoppigCart.getProducts(userId);
  }

  @PostMapping(value = "/user/{id}/shoppingCart")
  public void addProduct(@PathVariable(value = "id") int userId, @RequestBody int productId, @RequestBody int quantity){
    dbShoppigCart.addProduct(userId, productId, quantity);
  }

  @DeleteMapping(value = "/user/{id}/shoppingCart/{product}")
  public void removeProduct(@PathVariable(value = "id") int userId, @PathVariable(value = "product") int productId){
    dbShoppigCart.removeProduct(userId, productId);
  }

  @PutMapping(value = "/user/{id}/shoppingCart")
  public void buy(@PathVariable(value = "id") int userId){
    dbShoppigCart.buy(userId);
  }

  

}
