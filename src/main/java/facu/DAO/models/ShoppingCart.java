package facu.DAO.models;

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
  @Column(name = "quantity", nullable = false)
  private int quantity;
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id_user")
  private User user;
  @OneToMany(cascade = CascadeType.ALL)
  private List<Product> products = new ArrayList<>();



  public ShoppingCart(){}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public List<Product> getProducts() {
    return products;
  }

  public void setProducts(List<Product> products) {
    this.products = products;
  }

  public void addProduct(Product product){
    this.products.add(product);
  }

  public void removeProduct(Product product){
    this.products.remove(product);
  }

  public void removeProduct(int id_product) {
    this.products.removeIf(q-> q.getId() == id_product);
  }

  public void clear() {
    this.products.clear();
  }



}
