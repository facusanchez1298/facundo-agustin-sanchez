package facu.DAO.interfaces;

import facu.DAO.tables.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DaoShoppingCart extends JpaRepository<ShoppingCart, Integer> {

}
