package facu.dao.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class ShoppingCart {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_ShoppingCart", updatable = false, nullable = false)
  private int id;
  @OneToMany(mappedBy = "shoppingCart", cascade = CascadeType.ALL)
  private List<Products> products = new ArrayList<>();

  public ShoppingCart(){}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public List<Products> getProducts() {
    return products;
  }

  public void setProducts(List<Products> products) {
    this.products = products;
  }

  public void addProduct(@NotNull Product product, int quantity){
    this.products.add(new Products(product, this, quantity));
  }

  public void removeProduct(@NotNull Product product){
    this.products.removeIf(q-> q.getProduct() == product && q.getShoppingCart() == this);
  }

  public void removeProduct(int id_product) {
    this.products.removeIf(q-> q.getProduct().getId() == id_product && q.getShoppingCart() == this);
  }

  public void clear() {
    this.products.clear();
  }

  public List<Product> getProduct(){
    List<Product> products = new ArrayList<>();
    for (int i = 0; i < this.products.size(); i++) {
      products.add(this.products.get(i).getProduct());
    }
    return products;
  }
}
