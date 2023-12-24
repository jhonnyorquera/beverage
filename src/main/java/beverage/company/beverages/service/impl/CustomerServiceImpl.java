package beverage.company.beverages.service.impl;


import beverage.company.beverages.data.Customer;
import beverage.company.beverages.data.Discount;
import beverage.company.beverages.dto.DiscountDto;
import beverage.company.beverages.dto.RequestCustomerDto;
import beverage.company.beverages.dto.ResponseCustomerDto;
import beverage.company.beverages.repository.CustomerRepository;
import beverage.company.beverages.service.CustomerService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {


  private CustomerRepository customerRepository;

  @Override
  public ResponseCustomerDto insertCustomer(RequestCustomerDto requestCustomerDto) {

    ModelMapper modelMapper = new ModelMapper();
    Customer customerSaved= modelMapper.map(requestCustomerDto, Customer.class);

    return modelMapper.map(customerRepository.save(customerSaved), ResponseCustomerDto.class);
  }
}
