package facu.services.implementation;

import facu.dao.interfaces.DaoUser;
import facu.dao.models.Login;
import facu.dao.models.User;
import facu.excepciones.Classes.UserNullExeption;
import facu.services.incerfaces.LoginServices;

public class LoginServicesImp implements LoginServices {
  private final DaoUser dbUser;

  public LoginServicesImp(DaoUser dbUser) {
    this.dbUser = dbUser;
  }
  /**
   * save a user in the data base
   * @param user new user in the data base
   * @return the user id for authenticate
   */
  @Override
  public String SignUp(User user) {
      if(user == null)
        throw new UserNullExeption("the user entered is not valid");
      dbUser.save(user);
      return String.valueOf(user.getId());
  }
  /**
   * search for user in the data base
   * @param login user name and password
   * @return the user id for authenticate
   */
  @Override
  public String logIn(Login login) {
    User user = dbUser.findByUserName(login.getUserName());
    if (user == null)
      throw new UserNullExeption("the entered user name is not valid");
    if(!user.getPassword().equals(login.getPassword()))
      throw new UserNullExeption("the entered password is not valid");
    return String.valueOf(user.getId());
  }
  /**
   * compare the entered id with the id in data base
   * @param id user id from the header
   * @return true if the id is correct else return false
   */
  @Override
  public boolean correctCode(String id) {
    User user = dbUser.findById(Integer.parseInt(id)).get();
    return user != null;
  }
}
