package facu.DAO.interfaces;

import facu.DAO.models.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DaoStock extends JpaRepository<Stock, Integer> {

}
