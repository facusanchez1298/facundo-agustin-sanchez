package facu.DAO.tables;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "Stock")
@Table(name = "stock")
public class Stock {
  @Id
  @GeneratedValue
  private int id;
  @OneToOne( cascade = CascadeType.ALL)
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
