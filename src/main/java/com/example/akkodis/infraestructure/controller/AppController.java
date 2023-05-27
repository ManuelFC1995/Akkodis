package com.example.akkodis.infraestructure.controller;

import com.example.akkodis.application.utils.Tools;
import com.example.akkodis.domain.model.Prices;
import com.example.akkodis.domain.service.ProductService;
import com.example.akkodis.infraestructure.model.request.ProductRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prices")
@Slf4j
public class AppController {

    private final ProductService service;

    public AppController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Prices> getPrice(@Validated ProductRequest request) {
        log.info("Fetching price for product: {}", request.getProductId());
        if (!Tools.isValidDateFormat(request.getDate())) {
            return ResponseEntity.badRequest().build();
        }
        try {
            Prices prices = service.getProduct(request.getDate(), request.getProductId(), request.getBrandId());
            return ResponseEntity.status(prices != null ? HttpStatus.OK : HttpStatus.NO_CONTENT).body(prices);
        } catch (Exception e) {
            log.error("Error occurred while fetching price", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

