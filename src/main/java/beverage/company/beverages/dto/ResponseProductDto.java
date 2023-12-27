package beverage.company.beverages.dto;


import lombok.Data;

@Data
public class ResponseProductDto {

  private String name;
  private Double unitCost;
  private String markup;
  private String promotion;
}
