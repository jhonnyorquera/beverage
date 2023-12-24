package beverage.company.beverages.dto;


import java.util.List;
import lombok.Data;

@Data
public class RequestCustomerDto {

  private String alias;
  private double basicDiscountPercent;
  private List<DiscountDto> discountList;
}
