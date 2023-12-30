package beverage.company.beverages.service.impl;


import beverage.company.beverages.dto.DiscountDto;
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

    Map<String, String> orderInput = getQuantityByProduct(dto.getInput());
    ResponseCustomerDto customer = customerService.getCustomerByAlias(orderInput.get("Customer"));
    Map<String, ResponseProductDto> products = getProducts();
    List<OrderDetailDto> orderDetailDtos = getOrderDetail(products, orderInput);
    OrderDto orderDto = new OrderDto();
    orderDto.setCustomer(customer);
    orderDto.setDetails(orderDetailDtos);
    getDiscountsOverall(orderDto, customer);
    return orderDto;
  }


  private void getDiscountsOverall(OrderDto orderDto, ResponseCustomerDto customerDto) {
    double subtotal = orderDto.getDetails().stream().map(x -> x.getLineTotal()).reduce(0.0, Double::sum);
    orderDto.setSubtotal(subtotal);
    double basicDiscount = (customerDto.getBasicDiscountPercent()) / 100;
    orderDto.setDiscount(0.0);


    customerDto.getDiscountList().stream().forEach(x-> {
      getDiscountByCriteriaField(x, subtotal, orderDto);

    });

    Double totalDiscount= basicDiscount+orderDto.getDiscount();
    orderDto.setDiscount(subtotal*totalDiscount);
    if(orderDto.getDiscount()>0.0)
    orderDto.setTotal(orderDto.getSubtotal()-orderDto.getDiscount());


  }

  private void getDiscountByCriteriaField(DiscountDto discountDto, Double subtotal, OrderDto orderDto) {

    char criteria = discountDto.getCondition().charAt(0);
    double numberToCriteria = Double.parseDouble(discountDto.getCondition().substring(1));

    switch (criteria) {
      case '>':
        if (subtotal > numberToCriteria) {
          orderDto.setDiscount(discountDto.getValue() / 100);
        }
        break;

    }

  }

  private List<OrderDetailDto> getOrderDetail(Map<String, ResponseProductDto> mapDto, Map<String, String> orderInput) {
    List<OrderDetailDto> orderDetailDtoList = new ArrayList<>();
    mapDto.entrySet().stream().forEach(var -> {
      if (Integer.parseInt(orderInput.get(var.getKey())) > 0) {
        orderDetailDtoList.add(getOrderDetail(orderInput.get(var.getKey()), var.getValue()));
      }
    });

    return orderDetailDtoList;
  }


  private OrderDetailDto getOrderDetail(String quantity, ResponseProductDto productDto) {
    Integer quantityDet = Integer.parseInt(quantity);
    OrderDetailDto orderDetailDto = new OrderDetailDto();
    orderDetailDto.setAlias(productDto.getName());
    orderDetailDto.setQuantity(quantityDet);
    Double priceUnit = calcUnitCost(productDto);
    orderDetailDto.setBaseUnitPrice(priceUnit);
    orderDetailDto.setLineTotal(quantityDet * priceUnit);
    return orderDetailDto;
  }


  private Double calcUnitCost(ResponseProductDto dto) {
    Double markup = Double.parseDouble(dto.getMarkup());
    Double promotion = Double.parseDouble(dto.getPromotion());
    return Math.floor((dto.getUnitCost() * (markup / 100) * (promotion / 100)) * 1000) / 1000;
  }

  private Map<String, ResponseProductDto> getProducts() {
    Map<String, ResponseProductDto> dtoMap = new HashMap<>();
    dtoMap.put("ProductA", productService.getProductByName("A"));
    dtoMap.put("ProductB", productService.getProductByName("B"));
    dtoMap.put("ProductC", productService.getProductByName("C"));
    dtoMap.put("ProductD", productService.getProductByName("D"));
    return dtoMap;

  }


  private Map<String, String> getQuantityByProduct(String input) {

    String messageIncorrectSintax = "incorrect syntax in field input, input may contains 5 fields in the same input "
        + "separated by space, it should be like this '5 10000 0 20000 0'";
    if (input.length() < 9) {
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
