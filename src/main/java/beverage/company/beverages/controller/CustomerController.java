package beverage.company.beverages.controller;

import beverage.company.beverages.dto.RequestCustomerDto;
import beverage.company.beverages.dto.ResponseCustomerDto;
import beverage.company.beverages.service.CustomerService;
import java.util.ArrayList;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/customer")
@AllArgsConstructor
public class CustomerController {


  private CustomerService customerService;

  @PutMapping("/")
  public ResponseEntity<ResponseCustomerDto> saveCustomer(@RequestBody RequestCustomerDto dto){
    return new ResponseEntity<>(customerService.insertCustomer(dto), HttpStatus.CREATED);

  }


  @GetMapping("/")
  public ResponseEntity<ResponseCustomerDto> getCustomerByAlias(@RequestParam String alias){
    return new ResponseEntity<>(customerService.getCustomerByAlias(alias), HttpStatus.OK);

  }

  @PostMapping("/")
  private ResponseEntity<String> updateCustomer(@RequestBody RequestCustomerDto dto) {
    return new ResponseEntity<>(customerService.updateCustomer(dto), HttpStatus.OK);
  }

  @DeleteMapping("/")
  private ResponseEntity<String> deleteCustomer(@RequestParam String alias) {
    return new ResponseEntity<>(customerService.deleteCustomer(alias), HttpStatus.OK);
  }


}
