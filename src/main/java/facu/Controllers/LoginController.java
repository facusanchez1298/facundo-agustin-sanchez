package facu.controllers;

import facu.dao.models.Login;
import facu.dao.models.User;
import facu.services.incerfaces.LoginServices;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
  private final LoginServices dbLogin;

  public LoginController(LoginServices dbLogin) {
    this.dbLogin = dbLogin;
  }
  /**
   * save a user in the data base
   * @param user new user in the data base
   * @return the user id for authenticate
   */
  @PostMapping(value = "/signUp")
  public String createNewUser(@RequestBody User user){
    return dbLogin.SignUp(user);
  }
  /**
   * search for user in the data base
   * @param login user name and password
   * @return the user id for authenticate
   */
  @PostMapping(value = "/logIn")
  public String logIn(@RequestBody Login login){
    return dbLogin.logIn(login);
  }
}
