package beverage.company.beverages.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class RequestProductDto implements Comparable<RequestProductDto> {

  private String name;
  private Double unitCost;
  private String markup;
  private String promotion;
  private Boolean Status;

  @Override
  public String toString() {
    return "RequestProductDto{" +
        "hashCode=" + hashCode() +
        ", name='" + name + '\'' +
        ", unitCost='" + unitCost + '\'' +
        ", Status=" + Status +
        '}';
  }


  @Override
  public int compareTo(RequestProductDto o) {
    return this.name.compareTo(o.name);
  }
}
