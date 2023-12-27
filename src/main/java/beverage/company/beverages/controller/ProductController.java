package beverage.company.beverages.controller;


import beverage.company.beverages.dto.RequestCustomerDto;
import beverage.company.beverages.dto.RequestProductDto;
import beverage.company.beverages.dto.ResponseCustomerDto;
import beverage.company.beverages.dto.ResponseProductDto;
import beverage.company.beverages.service.ProductService;
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
@RequestMapping("/v1/product")
@AllArgsConstructor
public class ProductController {

  private ProductService service;

  @PutMapping("/")
  private ResponseEntity<ResponseProductDto> saveProduct(@RequestBody RequestProductDto dto){
    return new ResponseEntity<>(service.insertProduct(dto), HttpStatus.CREATED);
  }

  @GetMapping("/")
  private ResponseEntity<ResponseProductDto> getCustomerByAlias(@RequestParam String name){
    return new ResponseEntity<>(service.getProductByName(name), HttpStatus.OK);

  }

  @PostMapping("/")
  private ResponseEntity<String> updateCustomer(@RequestBody RequestProductDto dto) {
    return new ResponseEntity<>(service.updateProduct(dto), HttpStatus.OK);
  }

  @DeleteMapping("/")
  private ResponseEntity<String> deleteCustomer(@RequestParam String name) {
    return new ResponseEntity<>(service.deleteProduct(name), HttpStatus.OK);
  }



}
