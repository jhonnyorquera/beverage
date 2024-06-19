package beverage.company.beverages.dto;

import beverage.company.beverages.utils.Decimals;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDetailDto {
  private String alias;
  private Integer quantity;
  private Double baseUnitPrice;
  private Double lineTotal;


}
