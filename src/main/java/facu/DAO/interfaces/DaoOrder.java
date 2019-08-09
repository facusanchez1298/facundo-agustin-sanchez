package facu.dao.interfaces;

import facu.dao.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DaoOrder extends JpaRepository<Orders, Integer> {

}
