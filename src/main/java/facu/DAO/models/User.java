package facu.DAO.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id_user", updatable = false, nullable = false)
  private int id;
  @Column(name = "user_Name")
  private String userName;
  @Column(name = "address")
  private String address;
  @Column(name = "password")
  private String password;
  @Column(name = "name")
  private String name;
  @Column(name = "last_Name")
  private String lastName;
  @Column(name = "sur_name")
  private String surName;
  @Column(name = "age")
  private int age;
  @ManyToOne(optional = false, cascade = CascadeType.ALL)
  @JoinColumn(name = "id_shoppingCart", nullable = false)
  private ShoppingCart shoppingCart;

  public User(){

  }

  public User(int id, String userName, String address, String password, String name, String lastName, String surName, int age) {
    this.id = id;
    this.userName = userName;
    this.address = address;
    this.password = password;
    this.name = name;
    this.lastName = lastName;
    this.surName = surName;
    this.age = age;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getSurName() {
    return surName;
  }

  public void setSurName(String surName) {
    this.surName = surName;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public ShoppingCart getShoppingCart() {
    return shoppingCart;
  }

  public void setShoppingCart(ShoppingCart shoppingCart) {
    this.shoppingCart = shoppingCart;
  }
}


