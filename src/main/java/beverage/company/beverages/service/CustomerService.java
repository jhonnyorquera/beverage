package beverage.company.beverages.service;

import beverage.company.beverages.dto.RequestCustomerDto;
import beverage.company.beverages.dto.ResponseCustomerDto;

public interface CustomerService {

  ResponseCustomerDto insertCustomer(RequestCustomerDto requestCustomerDto);

  ResponseCustomerDto getCustomerByAlias(String alias);

  String updateCustomer(RequestCustomerDto requestCustomerDto);

  String deleteCustomer(String alias);

}
