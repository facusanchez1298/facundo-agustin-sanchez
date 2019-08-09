package facu.controllers;

import facu.dao.interfaces.DaoStock;
import facu.dao.models.Stock;
import facu.services.incerfaces.StockServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StrockController {
  @Autowired
  private StockServices dataStock;

  @GetMapping(value = "/stock")
  public List<Stock> getStock(){
    return dataStock.getAll();
  }
}
