package facu.services.incerfaces;

import facu.dao.models.Orders;
import java.util.Date;
import java.util.List;

public interface OrderServices {
  /**
   * return all the orders in the data base
   * @return all the orders in the data base
   */
  List<Orders> getAll(String authorization );
  /**
   * return all the orders with the same date
   * @param date order date
   * @return all the orders with the same date
   */
  List<Orders> getByDate(String authorization, Date date);
  /**
   * return all the orders with the same user
   * @param id_user order user
   * @return all the orders with the same user
   */
  List<Orders> getByUser(String authorization, int id_user);


}
