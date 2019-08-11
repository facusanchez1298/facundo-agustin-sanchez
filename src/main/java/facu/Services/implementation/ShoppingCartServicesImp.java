package facu.services.implementation;

import facu.dao.interfaces.DaoOrder;
import facu.dao.interfaces.DaoShoppingCart;
import facu.dao.interfaces.DaoStock;
import facu.dao.models.Orders;
import facu.dao.models.Product;
import facu.dao.models.Products;
import facu.dao.models.ShoppingCart;
import facu.dao.models.Stock;
import facu.excepciones.ExceptionController;
import facu.services.incerfaces.LoginServices;
import facu.services.incerfaces.ShoppingCartServices;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServicesImp implements ShoppingCartServices {
  private final DaoShoppingCart dbShoppingCart;
  private final DaoOrder dbOrder;
  private final DaoStock dbStock;
  private final LoginServices dbLogin;
  private final ExceptionController controller;

  public ShoppingCartServicesImp(DaoShoppingCart dbShoppingCart, DaoOrder dbOrder,
    DaoStock dbStock, LoginServices dbLogin, ExceptionController controller) {
    this.dbShoppingCart = dbShoppingCart;
    this.dbOrder = dbOrder;
    this.dbStock = dbStock;
    this.dbLogin = dbLogin;
    this.controller = controller;
  }
  /**
   * return all the product in the user's shopping cart
   * @param userId user id
   * @return all the product in the user's shopping cart
   */
  @Override
  public List<Product> getProducts(String authorization, int userId) {
    return dbShoppingCart.findByIdUser(userId).getProduct();
  }
  /**
   * add a product to shopping cart
   * @param userId user id from the sopping cart
   * @param product product to add
   * @param quantity product quantity in stock
   */
  @Override
  public void addProduct(String authorization, int userId, Product product, int quantity) {
    controller.correctUser(userId);
    controller.correctProduct(product);
    controller.enoughStock(product, quantity);
    dbShoppingCart.findByIdUser(userId).addProduct(product, quantity);
  }
  /**
   * add a product to shopping cart
   * @param userId user id from the sopping cart
   * @param productId product to add
   * @param quantity product quantity in stock
   */
  @Override
  public void addProduct(String authorization, int userId, int productId, int quantity) {
    controller.correctUser(userId);
    controller.enoughStock(productId,quantity );
    Product product = dbStock.findByProductId(productId).getProduct();
    controller.correctProduct(product);
    dbShoppingCart.findByIdUser(userId).addProduct(product, quantity);
  }
  /**
   * remove a product from the shopping cart
   * @param userId user id from the shopping cart
   * @param productId product id to remove
   */
  @Override
  public void removeProduct(String authorization, int userId, int productId) {
    controller.correctUser(userId);
    dbShoppingCart.findByIdUser(userId).removeProduct(productId);
  }
  /**
   * add the shopping cart to orders an empty it
   * @param userId user id from the shopping cart
   */
  @Override
  public void buy(String authorization, int userId) {
    ShoppingCart shoppingCart = dbShoppingCart.findByIdUser(userId);
    controller.correctUser(userId);
    controller.emptyShoppingCart(shoppingCart);
    subtractFromStock(shoppingCart);
    dbOrder.save(new Orders(shoppingCart));
    emptyShoppingCart(authorization, userId);
  }
  /**
   * subtract all the product in the shopping cart from the stock
   * @param shoppingCart
   */
  private void subtractFromStock(ShoppingCart shoppingCart){
    for (int i = 0; i < shoppingCart.getProducts().size(); i++) {
      Products products = shoppingCart.getProducts().get(i);
      Stock stock = dbStock.findByProduct(products.getProduct());
      stock.subtract(products.getQuantity());
    }
  }
  /**
   * clear the shopping cart
   * @param userId user id from the user's shopping cart
   */
  @Override
  public void emptyShoppingCart(String authorization, int userId) {
    controller.correctUser(userId);
    dbShoppingCart.findByIdUser(userId).clear();
  }
}
