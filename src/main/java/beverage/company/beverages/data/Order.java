package beverage.company.beverages.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.List;

@Entity
public class Order {
  @Id
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private Customer customer;
  private int subtotal;
  private double discount;
  private double total;
  private List<OrderDetail> details;

}
