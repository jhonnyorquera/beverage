package beverage.company.beverages.service;

import beverage.company.beverages.data.Customer;
import beverage.company.beverages.dto.RequestCustomerDto;
import beverage.company.beverages.dto.ResponseCustomerDto;

public interface CustomerService {

  ResponseCustomerDto insertCustomer(RequestCustomerDto requestCustomerDto);
}
