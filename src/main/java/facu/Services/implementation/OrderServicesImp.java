package facu.services.implementation;

import facu.dao.interfaces.DaoOrder;
import facu.dao.interfaces.DaoUser;
import facu.dao.models.Orders;
import facu.dao.models.User;
import facu.excepciones.UserNullExeption;
import facu.services.incerfaces.OrderServices;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServicesImp implements OrderServices {
  @Autowired
  private DaoOrder dbOrder;
  @Autowired
  private DaoUser dbUser;
  /**
   * return all the orders in the data base
   * @return all the orders in the data base
   */
  @Override
  public List<Orders> getAll() {
    return dbOrder.findAll();
  }
  /**
   * return all the orders with the same date
   * @param date order date
   * @return all the orders with the same date
   */
  @Override
  public List<Orders> getByDate(Date date){
    return dbOrder.findByDate(date);
  }
  /**
   * return all the orders with the same user
   * @param id_user order user
   * @return all the orders with the same user
   */
  @Override
  public List<Orders> getByUser(int id_user) {
    User user = dbUser.findById(id_user).get();
    if(user == null)
      throw new UserNullExeption("the entered id is not valid");
    return dbOrder.findByShoppingCart(id_user);
  }
}
