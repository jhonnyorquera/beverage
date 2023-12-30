package beverage.company.beverages.dto;


import beverage.company.beverages.data.OrderDetail;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderDto {
  private ResponseCustomerDto customer;
  private double subtotal;
  private double discount;
  private double total;
  private List<OrderDetailDto> details;

}
