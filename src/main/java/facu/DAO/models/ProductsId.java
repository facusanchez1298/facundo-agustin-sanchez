package facu.dao.models;

import java.io.Serializable;
import javax.persistence.Column;

public class ProductsId implements Serializable {

  @Column(name = "id_product")
  private int productId;
  @Column(name = "id_shopingcart")
  private int shoppingCartId;

  public ProductsId(){}
}
