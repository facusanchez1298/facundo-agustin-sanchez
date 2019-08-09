package facu.dao.interfaces;

import facu.dao.models.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DaoShoppingCart extends JpaRepository<ShoppingCart, Integer> {

  @Query(value = "select * from shopping_cart s where s.id_user = ?1", nativeQuery = true)
  ShoppingCart findByIdUser(int id);
}
