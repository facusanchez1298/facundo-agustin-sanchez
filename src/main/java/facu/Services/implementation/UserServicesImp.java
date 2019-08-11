package facu.services.implementation;

import facu.dao.interfaces.DaoShoppingCart;
import facu.dao.interfaces.DaoUser;
import facu.dao.models.Product;
import facu.dao.models.User;
import facu.excepciones.ExceptionController;
import facu.services.incerfaces.LoginServices;
import facu.services.incerfaces.UserServices;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserServicesImp implements UserServices {
  private final DaoUser dbUser;
  private final DaoShoppingCart dbShoppingCart;
  private final LoginServices dbLogin;
  private final ExceptionController controller;

  public UserServicesImp(DaoUser dbUser, DaoShoppingCart dbShoppingCart,
    LoginServices dbLogin, ExceptionController controller) {
    this.dbUser = dbUser;
    this.dbShoppingCart = dbShoppingCart;
    this.dbLogin = dbLogin;
    this.controller = controller;
  }
  /**
   * find a user by him id
   * @param id user id
   * @return a particular id
   */
  @Override
  public User findById(String authorization, int id) {
    dbLogin.correctCode(authorization);
    return dbUser.findById(id).get();
  }
  /**
   * return a user with the user name entered
   * @param userName user name for search
   * @return a user with the entered user name
   */
  @Override
  public User findByUserName(String authorization, String userName) {
    dbLogin.correctCode(authorization);
    return dbUser.findByUserName(userName);
  }
  /**
   * return all the users in the database
   * @return all the users in the dataBase
   */
  @Override
  public List<User> findAll(String authorization) {
    dbLogin.correctCode(authorization);
    return dbUser.findAll();
  }
  /**
   * delete a product from the dbUser base
   * @param id user id to delete
   */
  @Override
  public void removeUserById(String authorization, int id) {
    dbLogin.correctCode(authorization);
    dbUser.deleteById(id);
  }
  /**
   * update a user in the dbUser base
   * @param userId user id from user to change
   * @param user new dbUser for the user
   */
  @Override
  public void updateUserById(String authorization, int userId, User user) {
    dbLogin.correctCode(authorization);
    controller.correctUser(user);
    User dbUser = this.dbUser.getOne(userId);
    controller.correctUser(dbUser);
    user.setId(dbUser.getId()); //set the new user id, have to have the same id
    dbUser = user;
    this.dbUser.save(dbUser);
  }
  /**
   * add a product to the shopping cart
   * @param id user id
   * @param product product to add
   */
  @Override
  public void addProductToShoppingCart(String authorization, int id, Product product, int quantity) {
    dbLogin.correctCode(authorization);
    dbUser.getOne(id).getShoppingCart().addProduct(product,quantity );
  }
}
