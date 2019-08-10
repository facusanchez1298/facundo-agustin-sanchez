package facu.dao.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Id;

@Entity
public class ShoppingCart {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id_ShoppingCart", updatable = false, nullable = false)
  private int id;
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id_user")
  private User user;
  @OneToMany(mappedBy = "shoppingCart", cascade = CascadeType.ALL)
  private List<Products> products = new ArrayList<>();

  public ShoppingCart(){}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public List<Products> getProducts() {
    return products;
  }

  public void setProducts(List<Products> products) {
    this.products = products;
  }

  public void addProduct(Product product, int quantity){
    this.products.add(new Products(product, this, quantity));
  }

  public void removeProduct(Product product){
    this.products.removeIf(q-> q.getProduct() == product && q.getShoppingCart() == this);
  }

  public void removeProduct(int id_product) {
    this.products.removeIf(q-> q.getProduct().getId() == id_product && q.getShoppingCart() == this);
  }

  public void clear() {
    this.products.clear();
  }
}
