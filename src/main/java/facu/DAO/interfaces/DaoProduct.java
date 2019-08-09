package facu.dao.interfaces;

import facu.dao.models.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DaoProduct extends JpaRepository<Product, Integer> {

  List<Product> findByCategory(String category);
  List<Product> findByName(String name);

  @Query(value = "select * from Product p where p.name like %?1 and p.category = ?2", nativeQuery = true)
  List<Product> findByNameAndCategory(String name,  String category);
}
