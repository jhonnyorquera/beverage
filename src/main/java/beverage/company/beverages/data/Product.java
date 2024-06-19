package beverage.company.beverages.data;

import beverage.company.beverages.dto.RequestProductDto;
import beverage.company.beverages.repository.ProductRepository;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;


@Entity
@Data
public class Product {
  @Id
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String name;
  private Double unitCost;
  private String markup;
  private String promotion;
  private Boolean status;


  public void updateFromDto(RequestProductDto dto) {
    this.setPromotion(dto.getPromotion());
    this.setMarkup(dto.getMarkup());
    this.setUnitCost(dto.getUnitCost());
  }


}
