package beverage.company.beverages.dto;


import jakarta.validation.constraints.NotBlank;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestCustomerDto {

  @NotBlank(message = "invalid alias")
  private String alias;
  private double basicDiscountPercent;
  private List<DiscountDto> discountList;
}
