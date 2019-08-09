package facu.controllers;

import facu.dao.models.User;
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
  private UserServices userServices;
  /**
   * save a new user in the database
   * @param user
   */
  @PostMapping(value = "/signup")
  public void createNewUser(@RequestBody User user){
    userServices.saveUser(user);
  }
  /**
   * get all the users in the data base
   * @return all the users in the data base
   */
  @GetMapping(value = "/users")
  public List<User> getUser(){
    return userServices.findAll();
  }
  /**
   * return a user by him id
   * @param id user id from user to get
   * @return
   */
  @GetMapping(value = "/users/{id}")
  public User getUserById(@PathVariable("id") @NotBlank int id){
    return userServices.findById(id);
  }
  /**
   * remove a user from the data base
   * @param id user id for delete
   */
  @DeleteMapping(value = "/users/{id}")
  public void deleteUser(@PathVariable("id") @NotBlank int id){
    userServices.removeUserById(id);
  }
  /**
   * edit a user in the data base
   * @param id user id for user to change
   * @param user user whit the changes
   */
  @PutMapping(value = "/users/{id}")
  public void updateUser(@PathVariable("id") @NotBlank int id, @RequestBody User user){
    userServices.updateUserById(id, user);
  }
}