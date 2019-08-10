package facu.controllers;

import facu.dao.interfaces.DaoStock;
import facu.dao.models.Stock;
import facu.services.incerfaces.StockServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {
  @Autowired
  private StockServices dataStock;

  @GetMapping(value = "/stock")
  public List<Stock> getStock(){
    return dataStock.getAll();
  }

  @GetMapping(value = "/stock/availables")
  public List<Stock> getProductsAvailables(){
    return dataStock.getAvailables();
  }

  @GetMapping(value = "/stock/inavailabes")
  public List<Stock> getProductsInavailables(){
    return dataStock.getInavailables();
  }

  @GetMapping(value = "/stock/{id}/quantity")
  public int getQuantityById(@PathVariable(value = "id") int id_user){
    return dataStock.quantityOf(id_user);
  }

}
