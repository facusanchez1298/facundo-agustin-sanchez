package facu.DAO.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "Stock")
@Table(name = "stock")
public class Stock {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id_stock", updatable = false, nullable = false)
  private int id;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "product")
  private Product products;
  @Column
  private int quantity;
  @Column
  private boolean available;

  public Stock(){}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Product getProducts() {
    return products;
  }

  public void setProducts(Product products) {
    this.products = products;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public boolean isAvailable() {
    return available;
  }

  public void setAvailable(boolean available) {
    this.available = available;
  }
}
