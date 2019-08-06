package facu.Service.incerfaces;

import facu.DAO.tables.User;
import java.util.List;
import org.springframework.stereotype.Service;


public interface UserServices {

  public void saveUser(int id, String userName, String adress, String password, String name,
    String lastName, String surName, int age);

  public void saveUser(User user);

  public User findById(int id);

  List<User> findAll();
}
