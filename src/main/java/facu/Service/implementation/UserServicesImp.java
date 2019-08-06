package facu.Service.implementation;

import facu.DAO.interfaces.Dao;
import facu.DAO.tables.User;
import facu.Service.incerfaces.UserServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServicesImp implements UserServices {
  @Autowired
  private Dao data;

  @Override
  public void saveUser(int id, String userName, String andress, String password, String name,
    String lastName, String surName, int age) {
    User user = new User(id, userName, andress, password, name, lastName, surName, age);
    data.save(user);
  }

  @Override
  public void saveUser(User user) {
    data.save(user);
  }

  @Override
  public User findById(int id) {
    return data.findById(id).get();
  }

  @Override
  public List<User> findAll() {
    return data.findAll();
  }

}
