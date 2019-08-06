package facu.DAO.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
  @Id
  private int id;
  @Column(name = "user_Name")
  private String userName;
  @Column(name = "adress")
  private String adress;
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

  public User(){

  }

  public User(int id, String userName, String adress, String password, String name, String lastName, String surName, int age) {
    this.id = id;
    this.userName = userName;
    this.adress = adress;
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

  public String getAdress() {
    return adress;
  }

  public void setAdress(String adress) {
    this.adress = adress;
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
}
