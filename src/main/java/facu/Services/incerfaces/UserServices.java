package facu.Services.incerfaces;

import facu.DAO.models.Product;
import facu.DAO.models.User;
import java.util.List;


public interface UserServices {
  /**
   * save a new user in the data base
   * @param id user id for the new product
   * @param userName user username for the new product
   * @param address user address for the new product
   * @param password user password for the new product
   * @param name user name for the new product
   * @param lastName user last name for the new product
   * @param surName user sur name for the new product
   * @param age user age for the new product
   */
  public void saveUser(int id, String userName, String address, String password, String name,
    String lastName, String surName, int age);
  /**
   * save a new user in the database
   * @param user user for save
   */
  public void saveUser(User user);
  /**
   * return a particular user from the data base
   * @param id user id
   * @return a particular user
   */
  public User findById(int id);
  /**
   * return all the users in the database
   * @return all the users in the dataBase
   */
  List<User> findAll();
  /**
   * dele a user from the data base
   * @param id user id to delete
   */
  void removeUserById(int id);
  /**
   *  edit a user in the data base
   * @param id user id for update
   * @param user new data for update
   */
  void updateUserById(int id, User user);
  /**
   * add a product to the shopping cart
   * @param id user id
   * @param product product to add
   */
  void addProductToShoppingCart(int id, Product product);
}
