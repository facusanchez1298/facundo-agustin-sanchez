package facu.services.implementation;

import facu.dao.interfaces.DaoOrder;
import facu.dao.interfaces.DaoUser;
import facu.dao.models.Orders;
import facu.excepciones.ExceptionController;
import facu.services.incerfaces.LoginServices;
import facu.services.incerfaces.OrderServices;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class OrderServicesImp implements OrderServices {
  private final DaoOrder dbOrder;
  private final DaoUser dbUser;
  private final LoginServices dbLogin;
  private final ExceptionController controller;

  public OrderServicesImp(DaoOrder dbOrder, DaoUser dbUser,
    LoginServices dbLogin, ExceptionController controller) {
    this.dbOrder = dbOrder;
    this.dbUser = dbUser;
    this.dbLogin = dbLogin;
    this.controller = controller;
  }
  /**
   * return all the orders in the data base
   * @return all the orders in the data base
   */
  @Override
  public List<Orders> getAll(String authorization) {
    controller.correctAuthorization(authorization);
    return dbOrder.findAll();
  }
  /**
   * return all the orders with the same date
   * @param date order date
   * @return all the orders with the same date
   */
  @Override
  public List<Orders> getByDate(String authorization, Date date){
    controller.correctAuthorization(authorization);
    return dbOrder.findByDate(date);
  }
  /**
   * return all the orders with the same user
   * @param userId order user
   * @return all the orders with the same user
   */
  @Override
  public List<Orders> getByUser(String authorization, int userId) {
    controller.correctAuthorization(authorization);
    controller.correctUser(userId);
    return dbOrder.findByShoppingCart(userId);
  }
}
