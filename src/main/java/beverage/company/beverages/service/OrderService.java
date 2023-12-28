package beverage.company.beverages.service;

import beverage.company.beverages.dto.OrderDto;
import beverage.company.beverages.dto.RequestOrderDto;

public interface OrderService {

  OrderDto saverOrder(RequestOrderDto dto);

}
