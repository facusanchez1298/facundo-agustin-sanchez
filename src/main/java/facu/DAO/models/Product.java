package facu.DAO.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id_product", updatable = false, nullable = false)
  private int id;
  @Column
  private String name;
  @Column
  private float price;
  @Column
  private String description;
  @Column
  private String category;

  public Product(){}

  public Product(String name, float price, String description) {
    this.name = name;
    this.price = price;
    this.description = description;
  }

  public Product(int id, String name, float price, String description) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.description = description;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public float getPrice() {
    return price;
  }

  public void setPrice(float price) {
    this.price = price;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }
}
