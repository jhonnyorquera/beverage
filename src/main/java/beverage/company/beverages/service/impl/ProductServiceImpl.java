package beverage.company.beverages.service.impl;

import beverage.company.beverages.data.Customer;
import beverage.company.beverages.data.Product;
import beverage.company.beverages.dto.RequestProductDto;
import beverage.company.beverages.dto.ResponseCustomerDto;
import beverage.company.beverages.dto.ResponseProductDto;
import beverage.company.beverages.repository.ProductRepository;
import beverage.company.beverages.service.ProductService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImpl  implements ProductService {

  private ProductRepository repository;

  @Override
  public ResponseProductDto getProductByName(String name) {

    ModelMapper modelMapper = new ModelMapper();
    return modelMapper.map(getProductJust(name), ResponseProductDto.class);
  }


  @Override
  public ResponseProductDto insertProduct(RequestProductDto dto) {

    ModelMapper modelMapper = new ModelMapper();
    Product saved= modelMapper.map(dto, Product.class);
    saved.setStatus(Boolean.TRUE);
    return modelMapper.map(repository.save(saved), ResponseProductDto.class);

  }


  @Override
  public String updateProduct(RequestProductDto dto) {
    Product product = getProductJust(dto.getName());
    product.updateFromDto(dto);
    repository.save(product);
    return "product updated!";
  }

  @Override
  public String deleteProduct(String name) {
    Product product = getProductJust(name);
    product.setStatus(Boolean.FALSE);
    repository.save(product);
    return "product Deleted";
  }

  private Product getProductJust(String name){
     return repository.findFirstByNameAndStatus(name, Boolean.TRUE)
        .orElseThrow(() -> new RuntimeException("Product "+ name+" not Exist"));

  }






}
