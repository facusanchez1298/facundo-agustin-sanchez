package facu.dao.interfaces;

import facu.dao.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DaoUser extends JpaRepository<User, Integer> {

  User findByUserName(String userName);
}
