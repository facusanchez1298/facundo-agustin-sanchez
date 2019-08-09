package facu.DAO.interfaces;

import facu.DAO.models.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DaoProduct extends JpaRepository<Product, Integer> {

  List<Product> findByCategory(String category);
  List<Product> findByName(String name);

  @Query(value = "select * from Product u where u.name like %?1 and u.category = ?2", nativeQuery = true)
  List<Product> findByNameAndCategory(String name,  String category);
}
