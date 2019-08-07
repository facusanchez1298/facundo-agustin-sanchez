package facu.Services.implementation;

import facu.DAO.interfaces.DaoUser;
import facu.DAO.tables.User;
import facu.Services.incerfaces.UserServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServicesImp implements UserServices {
  @Autowired
  private DaoUser data;
  /**
   * save a user in the data base
   * @param id user id for the new product
   * @param userName user username for the new product
   * @param andress
   * @param password user password for the new product
   * @param name user name for the new product
   * @param lastName user last name for the new product
   * @param surName user sur name for the new product
   * @param age user age for the new product
   */
  @Override
  public void saveUser(int id, String userName, String andress, String password, String name,
    String lastName, String surName, int age) {
    User user = new User(id, userName, andress, password, name, lastName, surName, age);
    data.save(user);
  }
  /**
   * save a user a in the data base
   * @param user user for save
   */
  @Override
  public void saveUser(User user) {
    data.save(user);
  }
  /**
   * find a user by him id
   * @param id user id
   * @return a particular id
   */
  @Override
  public User findById(int id) {
    return data.findById(id).get();
  }
  /**
   * return all the users in the database
   * @return all the users in the dataBase
   */
  @Override
  public List<User> findAll() {
    return data.findAll();
  }
  /**
   * delete a product from the data base
   * @param id user id to delete
   */
  @Override
  public void removeUserById(int id) {
    data.deleteById(id);
  }

}
