package beverage.company.beverages.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Product {
  @Id
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String name;
  private Double unitCost;
  private String markup;
  private String promotion;
  private Boolean Status;

}
