package facu.services.incerfaces;

import facu.dao.models.Product;
import facu.dao.models.User;
import java.util.List;


public interface UserServices {
  /**
   * return a particular user from the data base
   * @param id user id
   * @return a particular user
   */
  public User findById(String authorization, int id);
  /**
   * return a user with the user name entered
   * @param userName user name for search
   * @return a user with the entered user name
   */
  public User findByUserName(String authorization, String userName);
  /**
   * return all the users in the database
   * @return all the users in the dataBase
   */
  List<User> findAll(String authorization);
  /**
   * dele a user from the data base
   * @param id user id to delete
   */
  void removeUserById(String authorization, int id);
  /**
   *  edit a user in the data base
   * @param id user id for update
   * @param user new data for update
   */
  void updateUserById(String authorization, int id, User user);
  /**
   * add a product to the shopping cart
   * @param id user id
   * @param product product to add
   */
  void addProductToShoppingCart(String authorization, int id, Product product, int quantity);


}
