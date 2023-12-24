package beverage.company.beverages.controller;

import beverage.company.beverages.dto.RequestCustomerDto;
import beverage.company.beverages.dto.ResponseCustomerDto;
import beverage.company.beverages.service.CustomerService;
import java.util.ArrayList;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/customer")
@AllArgsConstructor
public class CustomerController {


  private CustomerService customerService;

  @PostMapping("/")
  private ResponseEntity<ResponseCustomerDto> saveCustomer(@RequestBody RequestCustomerDto dto){
    return new ResponseEntity<>(customerService.insertCustomer(dto), HttpStatus.CREATED);

  }


}
