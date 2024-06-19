package beverage.company.beverages.dto;


import beverage.company.beverages.utils.Decimals;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDto {
  @NonNull
  private ResponseCustomerDto customer;
  private Double subtotal;
  private Double discount;
  private Double total;
  private List<OrderDetailDto> details;


  public void applyRound(){
    this.subtotal = Decimals.round(this.subtotal);
    this.discount = Decimals.round(this.discount);
    this.total = Decimals.round(this.total);
  }

 public void applyDiscount(){
   if(this.discount>0.0)
     this.total=this.subtotal-discount;
 }


}
