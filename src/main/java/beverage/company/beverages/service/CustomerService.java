package beverage.company.beverages.service;

import beverage.company.beverages.dto.RequestCustomerDto;
import beverage.company.beverages.dto.ResponseCustomerDto;
import java.util.List;

public interface CustomerService {

  ResponseCustomerDto insertCustomer(RequestCustomerDto requestCustomerDto);

  ResponseCustomerDto getCustomerByAlias(String alias);

  String updateCustomer(RequestCustomerDto requestCustomerDto);
}
