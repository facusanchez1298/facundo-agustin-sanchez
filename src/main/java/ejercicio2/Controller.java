package ejercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.BoxLayout;
import sun.security.krb5.internal.tools.Klist;

public class Controller {

  List<Blog> recentBlog;
  List<Blog> server;

  Scanner scanner;

  public Controller(){
    server = new ArrayList<Blog>();
    recentBlog = new ArrayList<Blog>();
    scanner = new Scanner(System.in);
  }

  public void addBlog(String nombre, String texto){
    server.add(new Blog(nombre, texto));
  }

  public void addBlog(Blog blog){
    server.add(blog);
  }

  public void removeBlog(int index){
    server.remove(index);
  }

  public void addRecentBlog(Blog blog){
    if(recentBlog.contains(blog)) { //if exists we remove itr
      recentBlog.remove(blog);
    }else if(recentBlog.size() >= 10) //if have 10 blogs we remove the first
      recentBlog.remove(0);

    recentBlog.add(blog); //add the new blog
  }

  public void showHome(){
    System.out.println("welcome to tiny blogs, what do you wanna do?"
      + "\n1- Create new blog"
      + "\n2- Delete a blog"
      + "\n3- Select a blogs"
      + "\n4- See the recent blogs"
      + "\n5- Close");

    switch (scanner.nextLine().charAt(0)){
      case '1':
        addBlog(createNewBlog());
        break;
      case '2':
        deleteBlog();
        break;
      case '3':
        selectABlog(server, false);
        break;
      case '4':
        selectABlog(recentBlog, true);
        break;
      case '5':
        System.exit(0);
        break;
      default:
        System.out.println("the entered number is not correct, please try again");
        break;
    }
    showHome();
  }

  //region add blog

  public Blog createNewBlog(){
    String name = "";
    String text = "";
    name = askForNotNullString("Please, enter the blog name: ", "name");
    text =  askForNotNullString("Please, enter the text of the blog", "text");
    return new Blog(name, text);
  }

  public String askForNotNullString(String message, String name){
    System.out.println(message);
    String text = "";
    while (text.equals("")){
      text = scanner.nextLine();
      if (text.equals(""))
        System.out.println("error: " + name + " is empty. Try again:");
    }
    return text;
  }

  //endregion

  private void selectABlog(List<Blog> list, boolean isRecent) {
    if (list.isEmpty()) {
      System.out.println("you don't have blogs to show");
      waitForKey();
      showHome();
    }else {
      System.out.println("what blog want you see?");
      if ((isRecent))
        showBlogs(list);
      else
        showRecentFiles(list);
      int index = askForIndex(list);
      showBlog(index, list);
    }
  }

  public void showBlog(int index, List<Blog> list){
    Blog blog = list.get(index - 1);
    System.out.println(blog.getName() + ":\n    " + blog.getText());
    addRecentBlog(blog);
    waitForKey();
  }

  public void deleteBlog(){
    System.out.println("select the blog to remove");
    showBlogs(server);
    int index = askForIndex(server) - 1;
    server.remove(index);
  }

  private int askForIndex(List list) {
    String enteredText = "";
    while (true){
      enteredText = scanner.nextLine();
      if (isNumber(enteredText)){
        int number = Integer.parseInt(enteredText);//si es numeral casteamos de texto a numero
        if (number <= list.size())
          return number;
        else
          System.out.println("the index not exists, try again: ");
      }else
        System.out.print("te char entered is not a number");
    }
  }

  public boolean isNumber(String string){
    try{
      int number = Integer.parseInt(string);
      return true;
    }catch (Exception e){
      return false;
    }
  }

  public void showBlogs(List<Blog> list){
    for (int i = 0; i < list.size(); i++) {
      System.out.println((i + 1) + " - " + list.get(i).getName());
    }
  }

  public void showRecentFiles(List<Blog> list){
    for (int j = list.size() - 1; j >= 0; j--) {
      System.out.println((j + 1) + " " + list.get(j).getName());
    }
  }

  private void waitForKey() {
    System.out.println("touch enter for continue...");
    scanner.nextLine();
  }
}
