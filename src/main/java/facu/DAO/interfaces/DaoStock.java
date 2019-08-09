package facu.dao.interfaces;

import facu.dao.models.Product;
import facu.dao.models.Stock;
import java.util.LinkedList;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DaoStock extends JpaRepository<Stock, Integer> {
  @Query(value = "select * from Stock s where id_product = ?1", nativeQuery = true)
  Stock findByProductId(int id_product);

  Stock findByProducts(Product product);

  List<Stock> findByAvailable(boolean state);


}
