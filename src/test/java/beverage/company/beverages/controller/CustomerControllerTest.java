package beverage.company.beverages.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerControllerTest {


  @LocalServerPort
  private int port;

  TestRestTemplate restTemplate = new TestRestTemplate();

  HttpHeaders headers = new HttpHeaders();



  @Test
  void deleteCustomer() {
    headers.setContentType(MediaType.APPLICATION_JSON);

    HttpEntity<String> entity = new HttpEntity<String>(null, headers);
    ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/v1/customer/?alias=8"),
        HttpMethod.DELETE, entity, String.class);

    HttpStatus actual = (HttpStatus) response.getStatusCode();

    assertEquals(actual, HttpStatus.NOT_FOUND);
  }

  @Test
  void getCustomerByAlias() {
    headers.setContentType(MediaType.APPLICATION_JSON);

    HttpEntity<String> entity = new HttpEntity<String>(null, headers);
    ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/v1/customer/?alias=8"), HttpMethod.GET,
        entity, String.class);

    HttpStatus actual = (HttpStatus) response.getStatusCode();

    assertEquals(actual, HttpStatus.NOT_FOUND);
  }


  private String createURLWithPort(String uri) {
    return "http://localhost:" + port + uri;
  }
}