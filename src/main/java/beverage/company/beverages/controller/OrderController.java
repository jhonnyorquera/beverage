package beverage.company.beverages.controller;


import beverage.company.beverages.dto.OrderDto;
import beverage.company.beverages.dto.RequestCustomerDto;
import beverage.company.beverages.dto.RequestOrderDto;
import beverage.company.beverages.dto.ResponseCustomerDto;
import beverage.company.beverages.service.OrderService;
import beverage.company.beverages.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/order")
@AllArgsConstructor
public class OrderController {

  private OrderService service;


  @PutMapping("/")
  private ResponseEntity<OrderDto> saveCustomer(@RequestBody RequestOrderDto dto){
    return new ResponseEntity<>(service.saverOrder(dto), HttpStatus.CREATED);
  }


}
