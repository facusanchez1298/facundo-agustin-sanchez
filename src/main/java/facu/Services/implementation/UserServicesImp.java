package facu.services.implementation;

import facu.dao.interfaces.DaoShoppingCart;
import facu.dao.interfaces.DaoUser;
import facu.dao.models.Product;
import facu.dao.models.ShoppingCart;
import facu.dao.models.User;
import facu.excepciones.UserNullExeption;
import facu.services.incerfaces.UserServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServicesImp implements UserServices {
  @Autowired
  private DaoUser dbUser;
  @Autowired
  private DaoShoppingCart dbShoppingCart;
  /**
   * save a user in the dbUser base
   * @param id user id for the new product
   * @param userName user username for the new product
   * @param address
   * @param password user password for the new product
   * @param name user name for the new product
   * @param lastName user last name for the new product
   * @param surName user sur name for the new product
   * @param age user age for the new product
   */
  @Override
  public void saveUser(int id, String userName,String type, String address, String password, String name,
    String lastName, String surName, int age) {
    User user = new User(id,userName,password,type,name,lastName,surName,age,address);
    dbUser.save(user);
  }
  /**
   * save a user a in the dbUser base
   * @param user user for save
   */
  @Override
  public void saveUser(User user) {
    dbUser.save(user);
  }
  /**
   * find a user by him id
   * @param id user id
   * @return a particular id
   */
  @Override
  public User findById(int id) {
    return dbUser.findById(id).get();
  }

  @Override
  public User findByUserName(String userName) {
    return dbUser.findByUserName(userName);
  }

  /**
   * return all the users in the database
   * @return all the users in the dataBase
   */
  @Override
  public List<User> findAll() {
    return dbUser.findAll();
  }
  /**
   * delete a product from the dbUser base
   * @param id user id to delete
   */
  @Override
  public void removeUserById(int id) {
    dbUser.deleteById(id);
  }
  /**
   * update a user in the dbUser base
   * @param id user id from user to change
   * @param user new dbUser for the user
   */
  @Override
  public void updateUserById(int id, User user) {
    if(user == null) throw new UserNullExeption("user is not valid");
    User dbUser = this.dbUser.getOne(id);
    if(dbUser != null){
      user.setId(dbUser.getId()); //set the new user id, have to have the same id
      dbUser = user;
      this.dbUser.save(dbUser);
    }
    else throw new UserNullExeption("the id entered is not valid");
  }
  /**
   * add a product to the shopping cart
   * @param id user id
   * @param product product to add
   */
  @Override
  public void addProductToShoppingCart(int id, Product product, int quantity) {
    dbUser.getOne(id).getShoppingCart().addProduct(product,quantity );
  }
}
