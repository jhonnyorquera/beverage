package beverage.company.beverages.service;

import beverage.company.beverages.dto.RequestProductDto;
import beverage.company.beverages.dto.ResponseProductDto;

public interface ProductService {

 ResponseProductDto insertProduct(RequestProductDto dto);

 ResponseProductDto getProductByName(String name);

 String updateProduct(RequestProductDto dto);

 String deleteProduct(String name);

}
