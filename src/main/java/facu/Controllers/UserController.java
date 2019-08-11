package facu.controllers;

import facu.dao.models.User;
import facu.services.incerfaces.UserServices;
import java.util.List;
import javax.validation.constraints.NotBlank;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
  private final UserServices dbUser;

  public UserController(UserServices dbUser) {
    this.dbUser = dbUser;
  }
  /**
   * return all the users in the database
   * @return all the users in the dataBase
   */
  @GetMapping(value = "/users")
  public List<User> getUser(@RequestHeader("authorization") String authorization){
    return dbUser.findAll(authorization);
  }
  /**
   * return a user by him id
   * @param id user id from user to get
   * @return
   */
  @GetMapping(value = "/users/{id}")
  public User getUserById(@RequestHeader("authorization") String authorization,
    @PathVariable("id") @NotBlank int id){
    return dbUser.findById(authorization, id);
  }
  /**
   * remove a user from the data base
   * @param id user id for delete
   */
  @DeleteMapping(value = "/users/{id}")
  public void deleteUser(@RequestHeader("authorization") String authorization,
    @PathVariable("id") @NotBlank int id){
    dbUser.removeUserById(authorization, id);
  }
  /**
   * edit a user in the data base
   * @param id user id for user to change
   * @param user user whit the changes
   */
  @PutMapping(value = "/users/{id}")
  public void updateUser(@RequestHeader("authorization") String authorization,
    @PathVariable("id") @NotBlank int id, @RequestBody User user){
    dbUser.updateUserById(authorization, id, user);
  }
}