package facu.services.incerfaces;

import facu.dao.models.Login;
import facu.dao.models.User;

public interface LoginServices {
  /**
   * save a user in the data base
   * @param user new user in the data base
   * @return the user id for authenticate
   */
  String SignUp(User user);
  /**
   * search for user in the data base
   * @param login user name and password
   * @return the user id for authenticate
   */
  String logIn(Login login);
}
