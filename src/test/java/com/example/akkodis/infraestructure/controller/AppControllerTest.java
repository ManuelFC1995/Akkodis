package com.example.akkodis.infraestructure.controller;

import org.junit.jupiter.api.AfterAll;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import com.example.akkodis.domain.model.Prices;
import com.example.akkodis.domain.service.ProductService;
import com.example.akkodis.infraestructure.model.request.ProductRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
@DataJpaTest
@ComponentScan
class AppControllerTest {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @MockBean
  @Autowired
  private ProductService productService;

  @Autowired
  private AppController appController;

  @BeforeEach
  void setup() {
    MockitoAnnotations.openMocks(this);

  }

  @Test
  void testGetPrice_ValidDate_ReturnsOK() {
    // Arrange
    String[] dates = {
        "2020-07-14 10:00:00",
        "2020-07-14 16:00:00",
        "2020-07-14 21:00:00",
        "2020-07-15 10:00:00",
        "2020-07-16 21:00:00"
    };
    int productId = 35455;
    int brandId = 1;
    ProductRequest request = new ProductRequest(dates[0], productId, brandId);
    Prices prices = new Prices(); // Create your expected Prices object

    when(productService.getProduct(anyString(), eq(productId), eq(brandId))).thenReturn(prices);

    for (String date : dates) {
      // Update the date in the request
      request.setDate(date);

      // Act
      ResponseEntity<Prices> response = appController.getPrice(request);

      // Assert
      assertEquals(HttpStatus.OK, response.getStatusCode());
      assertEquals(prices, response.getBody());
    }
  }



  @Test
  void testGetPrice_InvalidDate_ReturnsBadRequest() {
    // Arrange
    String invalidDate = "invalid-date";
    int productId = 123;
    int brandId = 456;
    ProductRequest request = new ProductRequest(invalidDate, productId, brandId);

    AppController appController = new AppController(mock(ProductService.class));

    // Act
    ResponseEntity<Prices> response = appController.getPrice(request);

    // Assert
    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    assertNull(response.getBody());
  }

  @Test
  void testGetPrice_ExceptionThrown_ReturnsInternalServerError() {
    // Arrange
    String date = "2020-07-14 18:00:00";
    int productId = 123;
    int brandId = 456;
    ProductRequest request = new ProductRequest(date, productId, brandId);

    ProductService productService = mock(ProductService.class);
    when(productService.getProduct(eq(date), eq(productId), eq(brandId))).thenThrow(new RuntimeException());

    AppController appController = new AppController(productService);

    // Act
    ResponseEntity<Prices> response = appController.getPrice(request);

    // Assert
    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    assertNull(response.getBody());
  }
}