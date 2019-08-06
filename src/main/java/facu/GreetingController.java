package facu;

import facu.DAO.interfaces.Dao;
import facu.DAO.tables.User;
import facu.Service.incerfaces.UserServices;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;
import javax.jws.Oneway;
import javax.tools.JavaCompiler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
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
}