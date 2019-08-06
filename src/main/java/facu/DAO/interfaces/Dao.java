package facu.DAO.interfaces;

import facu.DAO.tables.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Dao extends JpaRepository<User, Integer> {



}
