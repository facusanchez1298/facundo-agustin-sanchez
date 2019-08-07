package facu.Controllers;

import facu.DAO.tables.User;
import facu.Greeting;
import facu.Services.incerfaces.UserServices;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import javax.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
  @Autowired
  private UserServices userServices;

  private static final String template = "Hello, %s!";
  private final AtomicLong counter = new AtomicLong();

  @RequestMapping(value = "/greeting", method = RequestMethod.GET)
  public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
    return new Greeting(counter.incrementAndGet(),
      String.format(template, name));
  }

  @PostMapping(value = "/users")
  public void createNewUser(@RequestBody User user){
    userServices.saveUser(user);
  }

  @GetMapping(value = "/users")
  public List<User> getUser(){
    return userServices.findAll();
  }

  @GetMapping(value = "/users/{id}")
  public User getUserById(@PathVariable("id") @NotBlank int id){
    return userServices.findById(id);
  }

  @DeleteMapping(value = "/users/{id}")
  public void deleteUser(@PathVariable("id") @NotBlank int id){
    userServices.removeUserById(id);
  }
}