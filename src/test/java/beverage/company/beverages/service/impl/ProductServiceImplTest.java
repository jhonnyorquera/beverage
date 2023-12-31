package beverage.company.beverages.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import beverage.company.beverages.data.Customer;
import beverage.company.beverages.data.Product;
import beverage.company.beverages.dto.ResponseProductDto;
import beverage.company.beverages.repository.ProductRepository;
import beverage.company.beverages.service.ProductService;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceImplTest {

  @Autowired
  private ProductServiceImpl productService;

  @Mock
  private static ProductRepository productRepository;

  @BeforeTestClass
  public void init() {
    Product product= new Product();
    product.setId(1);
    product.setName("A");
    product.setMarkup("80");
    product.setUnitCost(10.00);
    product.setPromotion("10");

    List<Product> productList= new ArrayList<>();
    productList.add(product);
    Mockito.when(productRepository.findByNameAndStatus("A", Boolean.TRUE))
        .thenReturn(productList);

  }


  @Test
  void getProductByName() {
   // ResponseProductDto productToTes= productService.getProductByName("A");
 //   Assertions.assertEquals("A", productToTes.getName() );
  }

  @Test
  void deleteProduct() {
  }
}