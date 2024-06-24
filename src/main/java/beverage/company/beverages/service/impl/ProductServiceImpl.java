package beverage.company.beverages.service.impl;

import beverage.company.beverages.data.Customer;
import beverage.company.beverages.data.Product;
import beverage.company.beverages.dto.RequestProductDto;
import beverage.company.beverages.dto.ResponseCustomerDto;
import beverage.company.beverages.dto.ResponseProductDto;
import beverage.company.beverages.repository.ProductRepository;
import beverage.company.beverages.service.ProductService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImpl  implements ProductService {

  private ProductRepository repository;

  @Override
  public ResponseProductDto getProductByName(String name) {

    managementList();
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
    System.out.println("this is the name: "+name);
    return repository.findFirstByNameAndStatus(name, Boolean.TRUE)
        .orElseThrow(() -> new RuntimeException("Product "+ name+" not Exist"));

  }


  private void managementList (){
    List<RequestProductDto> lists= new ArrayList<>(Arrays.asList(getProductMock(1), getProductMock(2)));
     lists.add(getProductMock(1));
     System.out.println(" tipo LIST");
     lists.forEach(System.out::println);

    System.out.println(" tipo SET");
     Set<RequestProductDto> sets = new HashSet<>(lists);

    for (int i=1; i<10; i++){
      sets.add(getProductMock(i));
    }
    Optional<RequestProductDto> producFind =
        sets.stream().filter(a->a.getName().equals("10name")).findFirst();

    if (producFind.isPresent()){
      System.out.println("producto encontrado"+producFind);

    }
    sets.forEach(System.out::println);

    System.out.println("ORDENADO INSERT");
    Set<RequestProductDto> order= new TreeSet<>(sets);
    System.out.println("ORDENADO INSERT-----------");
    order.forEach(System.out::println);




  }

  private RequestProductDto getProductMock(Integer name){
    return  RequestProductDto.builder()
        .name(name.intValue() +"name")
        .unitCost(Double.valueOf(name)).Status(Boolean.TRUE).build();

  }



}
