package facu.dao.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

@Entity
public class Orders {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_Order", updatable = false, nullable = false)
  private int id;
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id_shoppingCart")
  @NotNull
  private ShoppingCart shoppingCarts;
  @Temporal(TemporalType.DATE)
  private Date date;

  public Orders(){}

  public Orders(ShoppingCart shoppingCarts) {
    this.shoppingCarts = shoppingCarts;
    this.date = new Date();
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public ShoppingCart getShoppingCarts() {
    return shoppingCarts;
  }

  public void setShoppingCarts(ShoppingCart shoppingCarts) {
    this.shoppingCarts = shoppingCarts;
  }


}
