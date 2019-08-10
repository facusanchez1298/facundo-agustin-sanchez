package facu.dao.interfaces;

import facu.dao.models.Orders;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DaoOrder extends JpaRepository<Orders, Integer> {

  List<Orders> findByDate(Date date);

  @Query(value = "select o.id_Order,o.id_shoppingCart, o.date "
    + "from Orders o, shoppingCart s "
    + "where o.id_shoppingCart = s.id_ShoppingCart and "
    + "s.id_user = ?1", nativeQuery =  true)
  List<Orders> findByShoppingCart(int id_user);
}
