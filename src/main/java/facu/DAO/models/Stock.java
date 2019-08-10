package facu.dao.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity(name = "Stock")
@Table(name = "stock")
public class Stock {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_stock", updatable = false, nullable = false)
  private int id;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id_product")
  @NotNull
  private Product product;
  @Column
  @NotNull
  private Integer quantity;
  @Column
  @NotNull
  private Boolean available;

  public Stock(){}

  public Stock(@NotNull Product product, int quantity, boolean available){
    this.product = product;
    this.quantity = quantity;
    this.available = available;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(@NotNull Product product) {
    this.product = product;
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

  public void subtract(int quantity){
    this.quantity -= quantity;
  }

  public void add(int quantity){
    this.quantity += quantity;
  }
}
