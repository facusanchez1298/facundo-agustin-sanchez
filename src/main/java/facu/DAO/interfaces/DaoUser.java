package facu.DAO.interfaces;

import facu.DAO.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DaoUser extends JpaRepository<User, Integer> {
}
