package facu.dao.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity(name = "product_shoppingCart")
@IdClass(ProductsId.class)
public class Products {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int productId;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int shoppingCartId;
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id_product", referencedColumnName = "id_product", insertable = false, updatable = false)
  @NotNull
  private Product product;
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id_product", referencedColumnName = "id_shoppingCart", insertable = false, updatable = false)
  @NotNull
  private ShoppingCart shoppingCart;
  @Column(name = "quantity", nullable = false)
  @NotNull
  @Min(0)
  private Integer quantity;

  public Products(){}

  public Products(@NotNull Product product, @NotNull ShoppingCart shoppingCart, int quantity) {
    this.product = product;
    this.shoppingCart = shoppingCart;
    this.quantity = quantity;
  }

  public Products(int productId, int shoppingCartId,
    @NotNull @Min(0) Integer quantity) {
    this.productId = productId;
    this.shoppingCartId = shoppingCartId;
    this.quantity = quantity;
  }

  public int getProductId() {
    return productId;
  }

  public void setProductId(int productId) {
    this.productId = productId;
  }

  public int getShoppingCartId() {
    return shoppingCartId;
  }

  public void setShoppingCartId(int shoppingCartId) {
    this.shoppingCartId = shoppingCartId;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public ShoppingCart getShoppingCart() {
    return shoppingCart;
  }

  public void setShoppingCart(ShoppingCart shoppingCart) {
    this.shoppingCart = shoppingCart;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
}
