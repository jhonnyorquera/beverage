package beverage.company.beverages.service.impl;


import beverage.company.beverages.dto.OrderDetailDto;
import beverage.company.beverages.dto.OrderDto;
import beverage.company.beverages.dto.RequestOrderDto;
import beverage.company.beverages.dto.ResponseCustomerDto;
import beverage.company.beverages.dto.ResponseProductDto;
import beverage.company.beverages.repository.OrderRepository;
import beverage.company.beverages.service.CustomerService;
import beverage.company.beverages.service.OrderService;
import beverage.company.beverages.service.ProductService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

  private CustomerService customerService;

  private ProductService productService;

  private OrderRepository repository;


  @Override
  public OrderDto saverOrder(RequestOrderDto dto) {

    Map<String, String> orderInput = getRequest(dto.getInput());
    ResponseCustomerDto customer = customerService.getCustomerByAlias(orderInput.get("Customer"));
    Map<String, ResponseProductDto> products= getProducts();
    List<OrderDetailDto> orderDetailDtos= getOrderDetail(products, orderInput);

    return null;
  }

  private List<OrderDetailDto> getOrderDetail(Map<String, ResponseProductDto> mapDto, Map<String, String> orderInput){
    List<OrderDetailDto> orderDetailDtoList = new ArrayList<>();
       mapDto.entrySet().stream().forEach(var-> {
         orderDetailDtoList.add(getOrderDetail(orderInput.get(var.getKey()), var.getValue()));
       });

    return  orderDetailDtoList;
  }


  private OrderDetailDto getOrderDetail(String quantity,ResponseProductDto productDto ) {
    Integer quantityDet =  Integer.parseInt(quantity) ;
    if (quantityDet > 0) {
      OrderDetailDto orderDetailDto = new OrderDetailDto();
      orderDetailDto.setQuantity(quantityDet);
      Double priceUnit = calcUnitCost(productDto);
      orderDetailDto.setBaseUnitPrice(priceUnit);
      orderDetailDto.setLineTotal(quantityDet * priceUnit);
      return orderDetailDto;
    } else {
      return new OrderDetailDto();
    }
  }

//to do
  private Double calcUnitCost(ResponseProductDto dto){
    return 1.0;
  }

  private Map<String, ResponseProductDto> getProducts() {
    Map<String, ResponseProductDto> dtoMap = new HashMap<>();
    dtoMap.put("ProductA", productService.getProductByName("A"));
    dtoMap.put("ProductB", productService.getProductByName("B"));
    dtoMap.put("ProductC", productService.getProductByName("C"));
    dtoMap.put("ProductD", productService.getProductByName("D"));
    return dtoMap;

  }


  private Map<String, String> getRequest(String input) {

    String messageIncorrectSintax = "incorrect syntax in field input, input may contains 5 fields in the same input "
        + "separated by space, it should be like this '5 10000 0 20000 0'";
    if (input.length() > 9) {
      throw new RuntimeException(messageIncorrectSintax);
    } else {
      String[] data = input.split(" ");
      if (data.length < 5) {
        throw new RuntimeException(messageIncorrectSintax);
      }
      Map<String, String> inputReady = new HashMap<>();
      inputReady.put("Customer", data[0]);
      inputReady.put("ProductA", data[1]);
      inputReady.put("ProductB", data[2]);
      inputReady.put("ProductC", data[3]);
      inputReady.put("ProductD", data[4]);
      return inputReady;
    }
  }
}
