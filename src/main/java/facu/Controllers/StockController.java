package facu.controllers;

import facu.dao.models.Product;
import facu.dao.models.Stock;
import facu.services.incerfaces.StockServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {
  @Autowired
  private StockServices dataStock;
  /**
   * return all products in stock
   * @return all products in stock
   */
  @GetMapping(value = "/stock")
  public List<Stock> getStock(){
    return dataStock.getAll();
  }
  /**
   * return all the available products in stock
   * @return all the available products in stock
   */
  @GetMapping(value = "/stock/availables")
  public List<Stock> getProductsAvailables(){
    return dataStock.getAvailables();
  }
  /**
   * return all the inavailable products in stock
   * @return all the inavailable products in stock
   */
  @GetMapping(value = "/stock/inavailabes")
  public List<Stock> getProductsInavailables(){
    return dataStock.getInavailables();
  }
  /**
   * return the product quantity in stock
   * @param idProduct product to search
   * @return the product quantity in stock
   */
  @GetMapping(value = "/stock/{id}/quantity")
  public int getQuantityById(@PathVariable(value = "id") int idProduct){
    return dataStock.quantityOf(idProduct);
  }
  /**
   * add a product to stock
   * @param product product to add
   * @param quantity product quantity
   * @param available is available?
   */
  @PostMapping(value = "/stock", params = {"product", "quantity", "available"})
  public void addNewProduct(@RequestParam(value = "product") Product product,
    @RequestParam(value = "quantity") int quantity, @RequestParam(value = "available")boolean available){
    dataStock.addProduct(product, quantity, available);
  }
  /**
   * add a product to stock
   * @param idProduct product to add
   * @param quantity product quantity
   * @param available is available?
   */
  @PostMapping(value = "/stock", params = {"id_product", "quantity", "available"})
  public void addNewProduct(@RequestParam(value = "id_product") int idProduct,
    @RequestParam(value = "quantity") int quantity, @RequestParam(value = "available")boolean available){
    dataStock.addProduct(idProduct, quantity, available);
  }
  /**
   * change a product state from stock product
   * @param available product state to change
   * @param productId product to disable
   */
  @PutMapping(value = "/stock/{id}", params = "available")
  public void  setAvailable(@PathVariable(value =  "id") int productId, @RequestParam(value = "available") boolean available){
    dataStock.setAvailableProduct(productId, available );
  }
  /**
   * define how much product there is
   * @param productId product to change the quantity
   * @param quantity product quantity
   */
  @PutMapping(value = "/stock/{id}", params = "quantity")
  public void  setQuantity(@PathVariable(value = "id") int productId, @RequestParam(value = "quantity") int quantity){
    dataStock.setQuantity(productId, quantity );
  }
}
