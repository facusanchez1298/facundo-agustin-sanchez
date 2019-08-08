package facu.DAO.tables;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ShoppingCart {
  @Id
  @GeneratedValue
  @Column(name = "id_ShoppingCart", updatable = false, nullable = false)
  private int id;
  @OneToMany(cascade = CascadeType.ALL)
  private List<Product> products = new ArrayList<>();
  @ManyToOne(optional = false, cascade = CascadeType.ALL)
  @JoinColumn(nullable = false)
  private User user;
  @Column(name = "quantity", nullable = false)
  private int quantity;

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

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
}
