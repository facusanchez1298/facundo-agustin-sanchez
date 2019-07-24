import DataBase.Product;
import Services.Services;
import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCart {
  private Services services = new Services();
  private ArrayList<Product> shoppingCart = new ArrayList<Product>();
  Scanner scanner = new Scanner(System.in);
  /**
   * control the program
   */
  public void showMain(){
    System.out.print(
      "welcome to compramatico!!"
      + "\n1 - create a new product"
      + "\n2 - see all the products"
      + "\n3 - edit a product"
      + "\n4 - remove a product"
      + "\n5 - add products to your sopping cart"
      + "\n6 - see you shopping cart"
      + "\n7 - close"
      + "\nwhat do you wanna do?: ");
      String answer = askForString("");
      switch (answer.charAt(0)){
        case '1':
          createNewProduct();
          break;
        case '2':
          showProducts();
          break;
        case '3':
          editProduct();
          break;
        case '4':
          removeProduct();
          break;
        case '5':
          addProductToShoppingCart();
          break;
        case '6':
          showShoppingCart();
          break;
        case '7': System.exit(0);
        default:
          System.out.println("index not exist. try again");
          break;
      }
      waitUserPress();
      showMain();
  }
  /**
   * add a existing product to shopping cart
   */
  private void addProductToShoppingCart() {
    showProducts();
    int index = askForInt("insert the index of the product that you want");
    while(!services.exist(index)) index = askForInt("the joined id is not valid, please try again: ");
    Product product = services.getProduct(index);
    product.setQuantity(askForInt("enter the quantity that you want"));
    shoppingCart.add(product);
  }
  /**
   * show all the product that you have in the shopping cart
   */
  private void showShoppingCart() {
    if (shoppingCart.isEmpty()) {
      System.out.println("don't have product to show");
    }
    else{
      System.out.printf("%-3s %-10s %-6s %-5s\n","id", "name", "price", "quality");
      shoppingCart.stream().
        forEach(q -> System.out.printf("%-3s %-10s %-6s %-5s\n", q.getId(), q.getName(), q.getPrice(), q.getQuantity()));
    }
  }
  /**
   * wait for the user to press a key enter
   */
  public void waitUserPress(){
    System.out.println("press enter for continue...");
    scanner.nextLine();
 }
  /**
   * return true if the string can be casted to float
   * @param number string to we will try to cast
   * @return true if can be casted and false if not
   */
  private boolean isFloat(String number){
    try {
      float numero = Float.parseFloat(number);
      return true;
    }catch (Exception e){
      return false;
    }
  }
  /**
   * return true if the string can be casted to int
   * @param number string to we will try to cast
   * @return
   */
  private boolean isInt(String number){
    try {
      float numero = Integer.parseInt(number);
      return true;
    }catch (Exception e){
      return false;
    }
  }

  //region Crud
  /**
   * show all the product contents in the data base
   */
  public void showProducts(){
    System.out.println("\nhere's all the product:");
    services.showProducts();
    waitUserPress();
  }
  /**
   * ask for the data for make a new product and add in the data base
   */
  public void createNewProduct(){
    System.out.println("welcome to product maker. ");
    String name = askForString("please introduce a product name: ");
    float price = askForFloat("please introduce a product price: ");
    int quality = askForInt("how many you have?");
    String description;
    if(askForContinue("want add a product description?")){
      description = askForString("please introduce a product description: ");
      services.SaveProduct(name, price, quality, description);
    }
    else services.SaveProduct(name, price, quality);
  }
  /**
   * delete a product from the data base
   */
  private void removeProduct() {
    if (!services.isEmtpy()) {
      System.out.println("welcome to product remover");
      showProducts();
      int index = askForInt("which product want you remove?:");
      while (!services.exist(index)) {
        System.out.println("id joined does not exists, please try again.");
        index = askForInt("which product want you remove?");
      }
      services.removeProduct(index);
      System.out.println("product deleted");
    } else
      System.out.println("don't have nothing to delete");
  }
  /**
   * edit a product from the data base
   */
  private void editProduct() {
    if (!services.isEmtpy()) {
      System.out.println("welcome to the product editor");
      showProducts();
      int index = askForInt("which product want you edit?:");
      while (!services.exist(index)) {
        System.out.println("id joined does not exists, please try again.");
        index = askForInt("which product want you edit?");
      }
      String name = askForString("enter the new product name");
      float price = askForFloat("enter the new product price");
      int quantity = askForInt("enter the quantity that you have");
      String description = askForString("enter the new product description");
      services.editProduct(index, name, price, quantity, description);
      System.out.println("product edited");
    } else
      System.out.println("you don't have nothing to edit");
  }
  //endregion

  //region asking for something
  /**
   * ask for a string for cast him to int
   * @param message message for show in the screen before to get the data
   * @return a casted number
   */
  private int askForInt(String message) {
    System.out.println(message);
    int number;
    String string = scanner.nextLine();
    if(!isInt(string)) number = askForInt("error, joined string is not a int, try again: ");
    number = Integer.parseInt(string);
    return number;
  }
  /**
   * ask for a string for cast him to float
   * @param message message for show in the screen before to get the data
   * @return a casted number
   */
  private float askForFloat(String message) {
    System.out.println(message);
    float number;
    String string = scanner.nextLine();
    if(!isFloat(string)) number = askForFloat("error, a joined string is not a float, try again");
    number = Float.parseFloat(string);
    return number;
  }
  /**
   * show a ask and return if the user want continue or not
   * @param message ask to do
   * @return true if the user joined yes or 1 and false if joined no and 2
   */
  public boolean askForContinue(String message){
    System.out.println(message + "\n1 - yes\n2 - no");
    String answer = scanner.nextLine();
    if(answer == null) answer = scanner.nextLine();
    switch (answer.toLowerCase()) {
      case "yes":
        return true;
      case "1":
        return true;
      case "no":
        return false;
      case "2":
        return false;
      default: {
        System.out.println("the index does not exists, please try again");
        return askForContinue(message);
      }
    }
  }
  /**
   * ask for a string
   * @param message message to show before to enter the string
   * @return String not null and not empty
   */
  public String askForString(String message){
    System.out.print(message + " ");
    String string = scanner.nextLine();
    if((string == null) || string.isEmpty()) string = askForString("");
    return string;
  }
  //endregion
}
