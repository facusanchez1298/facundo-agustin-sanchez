package facu.DAO.interfaces;

import facu.DAO.models.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DaoShoppingCart extends JpaRepository<ShoppingCart, Integer> {

  @Query(value = "select * from shopping_cart u where u.id_user = ?1", nativeQuery = true)
  ShoppingCart findByIdUser(int id);
}
