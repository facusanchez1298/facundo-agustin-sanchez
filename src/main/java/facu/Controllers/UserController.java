package facu.controllers;

import facu.dao.models.Login;
import facu.dao.models.User;
import facu.excepciones.UserNullExeption;
import facu.services.incerfaces.UserServices;
import java.util.List;
import javax.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
  @Autowired
  private UserServices dbUser;
  /**
   * save a new user in the database
   * @param user
   */
  @PostMapping(value = "/signUp")
  public void createNewUser(@RequestBody User user){
    dbUser.saveUser(user);
  }
  /**
   * get all the users in the data base
   * @return all the users in the data base
   */
  @GetMapping(value = "/logIn")
  public String logIn(@RequestBody Login login){
    User user = dbUser.findByUserName(login.getUserName());
    if (user == null)
      throw new UserNullExeption("the entered user name is not valid");
    if(!user.getPassword().equals(login.getPassword()))
      throw new UserNullExeption("the entered password is not valid");
    return "200: action successful";
  }

  @GetMapping(value = "/users")
  public List<User> getUser(){
    return dbUser.findAll();
  }
  /**
   * return a user by him id
   * @param id user id from user to get
   * @return
   */
  @GetMapping(value = "/users/{id}")
  public User getUserById(@PathVariable("id") @NotBlank int id){
    return dbUser.findById(id);
  }
  /**
   * remove a user from the data base
   * @param id user id for delete
   */
  @DeleteMapping(value = "/users/{id}")
  public void deleteUser(@PathVariable("id") @NotBlank int id){
    dbUser.removeUserById(id);
  }
  /**
   * edit a user in the data base
   * @param id user id for user to change
   * @param user user whit the changes
   */
  @PutMapping(value = "/users/{id}")
  public void updateUser(@PathVariable("id") @NotBlank int id, @RequestBody User user){
    dbUser.updateUserById(id, user);
  }
}