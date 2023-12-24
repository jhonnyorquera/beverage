package beverage.company.beverages.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderDetail {
  @Id
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @ManyToOne
  @JsonIgnore
  private Order order;


  private Integer quantity;
  private Double baseUnitPrice;
  private Double lineTotal;

}
