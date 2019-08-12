package facu.excepciones;

import facu.dao.interfaces.DaoShoppingCart;
import facu.dao.interfaces.DaoStock;
import facu.dao.interfaces.DaoUser;
import facu.dao.models.Product;
import facu.dao.models.ShoppingCart;
import facu.dao.models.Stock;
import facu.dao.models.User;
import facu.excepciones.Classes.EmptyShoppingCartException;
import facu.excepciones.Classes.LowerQuantityException;
import facu.excepciones.Classes.NotEnoughStockException;
import facu.excepciones.Classes.ProductNullException;
import facu.excepciones.Classes.StockNullException;
import facu.excepciones.Classes.UnauthorizerUserException;
import facu.excepciones.Classes.UserNullExeption;

public class ExceptionController {
  private final DaoStock dbStock;
  private final DaoShoppingCart dbShoppingCart;
  private final DaoUser dbUser;

  public ExceptionController(DaoStock dbStock, DaoShoppingCart dbShoppingCart,
    DaoUser dbUser) {
    this.dbStock = dbStock;
    this.dbShoppingCart = dbShoppingCart;
    this.dbUser = dbUser;
  }
  /**
   * launch a exception if the user id is null
   * @param userId user id for search
   */
  public void correctUser(int userId){
    if(dbShoppingCart.findByIdUser(userId) == null)
      throw new UserNullExeption("the entered user id is not valid");
  }
  /**
   * launch a exception if the user is null
   * @param user user for search
   */
  public void correctUser(User user){
    if(user == null)
      throw new UserNullExeption("the id entered is not valid");
  }
  /**
   * launch a exception if the product is null
   * @param product product for search
   */
  public void correctProduct(Product product){
    if(product == null)
      throw new ProductNullException("the product entered is null");
  }
  /**
   * launch a exception if the product is null
   * @param stock stock for search
   */
  public void correctStock(Stock stock){
    if(stock == null)
      throw new StockNullException("the entered id is not valid");
  }
  /**
   * launch a exception if the quantity is lower to 0
   * @param quantity quantity to compare
   */
  public void correctQuantity(int quantity){
    if (quantity < 0)
      throw new LowerQuantityException("the entered number can't be lower to 0");
  }
  /**
   * launch a exception if the quantity entered is upper to stock quantity
   * @param productId product to search
   * @param quantity quantity that you want
   */
  public void enoughStock(Product productId, int quantity){
    if(dbStock.findByProduct(productId).getQuantity() < quantity)
      throw new NotEnoughStockException("the quantity entered is upper to stock quantity");
  }
  /**
   * launch a exception if the shopping cart is empty
   * @param shoppingCart shopping cart for compare
   */
  public void emptyShoppingCart(ShoppingCart shoppingCart){
    if(shoppingCart.getProducts().isEmpty())
      throw new EmptyShoppingCartException("you can't buy, you shopping cart is empty");
  }
  /**
   * launch a exception if the quantity entered is upper to product quantity in the stock
   * @param productId product for search in the stock
   * @param quantity quantity for compare
   */
  public void enoughStock(int productId, int quantity){
    if(dbStock.findByProductId(productId).getQuantity() < quantity)
      throw new NotEnoughStockException("the quantity entered is upper to stock quantity");
  }
  /**
   * compare the entered id with the id in data base
   * @param id user id from the header
   * @return true if the id is correct else return false
   */
  public void correctAuthorization(String id) {
    User user = dbUser.findById(Integer.parseInt(id)).get();
    if(user == null)
      throw new UnauthorizerUserException("401: you have to start session for continue");
  }
}
