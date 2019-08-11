package facu.controllers;

import facu.dao.models.Orders;
import facu.services.incerfaces.OrderServices;
import java.util.Date;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
  private final OrderServices stockServices;

  public OrderController(OrderServices stockServices) {
    this.stockServices = stockServices;
  }
  /**
   * return all the orders in the data base
   * @return all the orders in the data base
   */
  @GetMapping(value = "/orders")
  public List<Orders> getAll(@RequestHeader("authorization") String authorization){
    return stockServices.getAll(authorization);
  }
  /**
   * return all the orders with the same date
   * @param date order date
   * @return all the orders with the same date
   */
  @GetMapping("/orders/{date}")
  public List<Orders> getByDate(@RequestHeader("authorization") String authorization,
    @PathVariable(value = "date") Date date){
    return stockServices.getByDate(authorization, date);
  }
  /**
   * return all the orders with the same user
   * @param id_user order user
   * @return all the orders with the same user
   */
  @GetMapping("/orders/shoppingcart/user/{id}")
  public List<Orders> getbyUserId(@RequestHeader("authorization") String authorization,
    @PathVariable(value = "id") int id_user){
    return stockServices.getByUser(authorization, id_user);
  }
}
