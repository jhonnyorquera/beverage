package beverage.company.beverages.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailDto {
  private String alias;
  private Integer quantity;
  private Double baseUnitPrice;
  private Double lineTotal;


}
