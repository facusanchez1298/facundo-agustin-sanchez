package facu.Services.implementation;

import facu.DAO.interfaces.DaoOrder;
import facu.DAO.interfaces.DaoShoppingCart;
import facu.DAO.models.Product;
import facu.DAO.models.ShoppingCart;
import facu.Services.incerfaces.ShoppingCartServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServicesImp implements ShoppingCartServices {
  @Autowired
  private DaoShoppingCart data;
  @Autowired
  private DaoOrder dbOrder;
  /**
   * add a product to shopping cart
   * @param id_user user id from the sopping cart
   * @param product product to add
   */
  @Override
  public void addProduct(int id_user, Product product) {
    if(data.findByIdUser(id_user) == null) throw new RuntimeException("the entered user id is not valid");
    if(product == null) throw new RuntimeException("the product entered is not valid");
    data.findByIdUser(id_user).addProduct(product);
  }
  /**
   * remove a product from the shopping cart
   * @param id_user user id from the shopping cart
   * @param id_product product id to remove
   */
  @Override
  public void removeProduct(int id_user, int id_product) {
    if(data.findByIdUser(id_user) == null) throw new RuntimeException("the entered user id is not valid");
    data.findByIdUser(id_user).removeProduct(id_product);
  }
  /**
   * add the shopping cart to orders an empty it
   * @param id_user user id from the shopping cart
   */
  @Override
  public void buy(int id_user) {
    ShoppingCart shoppingCart;
    if((shoppingCart = data.findByIdUser(id_user)) == null)
      throw new RuntimeException("the entered user id is not valid");
    if(shoppingCart.getProducts().isEmpty()) throw new RuntimeException("you can't buy, you shopping cart is empty");
    //dbOrder.save(new Orders(shoppingCart));
    emptyShoppingCart(id_user);
  }
  /**
   * clear the shopping cart
   * @param id_user user id from the user's shopping cart
   */
  @Override
  public void emptyShoppingCart(int id_user) {
    if((data.findByIdUser(id_user)) == null) throw new RuntimeException("the entered user id is not valid");
    data.findByIdUser(id_user).clear();
  }
}
