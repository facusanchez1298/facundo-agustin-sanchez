package facu.services.incerfaces;

import com.sun.org.apache.xpath.internal.functions.FuncSubstring;
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
  /**
   * compare the entered id with the id in data base
   * @param id user id from the header
   * @return true if the id is correct else return false
   */
  boolean correctCode(String id);
}
