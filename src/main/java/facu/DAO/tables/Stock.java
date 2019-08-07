package facu.DAO.tables;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "Stock")
@Table(name = "stock")
public class Stock {
  @Id
  @GeneratedValue
  private int id;
  @OneToMany(
    mappedBy = "stock",
    cascade = CascadeType.ALL,
    orphanRemoval = true
  )
  private List<Product> products = new ArrayList<>();
  @Column
  private int quantity;
  @Column
  private boolean available;

}
