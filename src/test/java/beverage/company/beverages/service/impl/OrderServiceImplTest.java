package beverage.company.beverages.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import beverage.company.beverages.dto.ResponseProductDto;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrderServiceImplTest {

  @Autowired
  private OrderServiceImpl orderService;

  @Test
  void testGetQuantityProd() {
    Map<String, String > mapToTest= new HashMap<>();
    mapToTest=orderService.getQuantityByProduct("5 100000 0 3000 6");
    Assertions.assertEquals(5, mapToTest.size());

  }

  @Test
  void testGetUnitCost(){
    ResponseProductDto productDto= new ResponseProductDto();
    productDto.setUnitCost(10.00);
    productDto.setMarkup(String.valueOf(80.00));
    productDto.setPromotion(String.valueOf(10.00));
    productDto.setName("D");

    Double valueGetFromMethod= orderService.calcUnitCost(productDto);
    Assertions.assertEquals(7.00, valueGetFromMethod);



  }

}