package beverage.company.beverages.service.impl;


import beverage.company.beverages.data.Customer;
import beverage.company.beverages.dto.RequestCustomerDto;
import beverage.company.beverages.dto.ResponseCustomerDto;
import beverage.company.beverages.repository.CustomerRepository;
import beverage.company.beverages.service.CustomerService;
import java.util.List;
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

  @Override
  public ResponseCustomerDto getCustomerByAlias(String alias) {
    ModelMapper modelMapper = new ModelMapper();
    return  modelMapper.map(getCustomerJust(alias), ResponseCustomerDto.class);
  }

  @Override
  public String updateCustomer(RequestCustomerDto requestCustomerDto) {
    Customer customer= getCustomerJust(requestCustomerDto.getAlias());
    customer.setBasicDiscountPercent(requestCustomerDto.getBasicDiscountPercent());
     customerRepository.save(customer);
     return "Customer Updated!";
  }

  private Customer getCustomerJust(String alias){
    List<Customer> customer=customerRepository.findByalias(alias);
    if (customer.size() < 1) {
      throw new RuntimeException("Customer not exist");
    }
    return customer.get(0);
  }


}
