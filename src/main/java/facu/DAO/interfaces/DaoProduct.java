package facu.DAO.interfaces;

import facu.DAO.tables.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DaoProduct extends JpaRepository<Product, Integer> {

}
