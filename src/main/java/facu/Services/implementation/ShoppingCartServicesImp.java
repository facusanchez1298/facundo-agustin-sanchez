package facu.services.implementation;

import facu.dao.interfaces.DaoOrder;
import facu.dao.interfaces.DaoShoppingCart;
import facu.dao.interfaces.DaoStock;
import facu.dao.models.Orders;
import facu.dao.models.Product;
import facu.dao.models.Products;
import facu.dao.models.ShoppingCart;
import facu.dao.models.Stock;
import facu.excepciones.EmptyShoppingCartException;
import facu.excepciones.NotEnoughStockException;
import facu.excepciones.ProductNullException;
import facu.excepciones.UserNullExeption;
import facu.services.incerfaces.ShoppingCartServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServicesImp implements ShoppingCartServices {
  @Autowired
  private DaoShoppingCart dbShoppingCart;
  @Autowired
  private DaoOrder dbOrder;
  @Autowired
  private DaoStock dbStock;
  /**
   * return all the product in the user's shopping cart
   * @param userId user id
   * @return
   */
  @Override
  public List<Product> getProducts(int userId) {
    return dbShoppingCart.findByIdUser(userId).getProduct();
  }
  /**
   * add a product to shopping cart
   * @param id_user user id from the sopping cart
   * @param product product to add
   * @param quantity product quantity in stock
   */
  @Override
  public void addProduct(int id_user, Product product, int quantity) {
    if(dbShoppingCart.findByIdUser(id_user) == null)
      throw new UserNullExeption("the entered user id is not valid");
    if(product == null)
      throw new ProductNullException("the product entered is not valid");
    if(dbStock.findByProduct(product).getQuantity() < quantity)
      throw new NotEnoughStockException("the quantity entered is upper to stock quantity");
    dbShoppingCart.findByIdUser(id_user).addProduct(product, quantity);
  }
  /**
   * add a product to shopping cart
   * @param id_user user id from the sopping cart
   * @param productId product to add
   * @param quantity product quantity in stock
   */
  @Override
  public void addProduct(int id_user, int productId, int quantity) {
    if(dbShoppingCart.findByIdUser(id_user) == null)
      throw new UserNullExeption("the entered user id is not valid");
    if(dbStock.findByProductId(productId).getQuantity() < quantity)
      throw new NotEnoughStockException("the quantity entered is upper to stock quantity");
    Product product = dbStock.findByProductId(productId).getProduct();
    if(product == null)
      throw new ProductNullException("the entered product id is not valid");
    dbShoppingCart.findByIdUser(id_user).addProduct(product, quantity);
  }
  /**
   * remove a product from the shopping cart
   * @param id_user user id from the shopping cart
   * @param id_product product id to remove
   */
  @Override
  public void removeProduct(int id_user, int id_product) {
    if(dbShoppingCart.findByIdUser(id_user) == null)
      throw new UserNullExeption("the entered user id is not valid");
    dbShoppingCart.findByIdUser(id_user).removeProduct(id_product);
  }
  /**
   * add the shopping cart to orders an empty it
   * @param id_user user id from the shopping cart
   */
  @Override
  public void buy(int id_user) {
    ShoppingCart shoppingCart;
    if((shoppingCart = dbShoppingCart.findByIdUser(id_user)) == null)
      throw new UserNullExeption("the entered user id is not valid");
    if(shoppingCart.getProducts().isEmpty())
      throw new EmptyShoppingCartException("you can't buy, you shopping cart is empty");
    subtractFromStock(shoppingCart);
    dbOrder.save(new Orders(shoppingCart));
    emptyShoppingCart(id_user);
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
   * @param id_user user id from the user's shopping cart
   */
  @Override
  public void emptyShoppingCart(int id_user) {
    if((dbShoppingCart.findByIdUser(id_user)) == null)
      throw new UserNullExeption("the entered user id is not valid");
    dbShoppingCart.findByIdUser(id_user).clear();
  }
}
