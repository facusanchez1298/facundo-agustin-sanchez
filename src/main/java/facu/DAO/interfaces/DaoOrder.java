package facu.DAO.interfaces;

import facu.DAO.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DaoOrder extends JpaRepository<Orders, Integer> {

}
