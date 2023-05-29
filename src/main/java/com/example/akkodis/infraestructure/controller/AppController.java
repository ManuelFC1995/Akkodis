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
@RequestMapping(value = "/prices")
@Slf4j
public class AppController {

    private final ProductService service;

    public AppController(ProductService service) {
        this.service = service;
    }

    /**
     * Obtiene el precio de un producto según la solicitud proporcionada.
     *
     * @param request Solicitud de producto
     * @return ResponseEntity con el objeto Prices en el cuerpo de la respuesta
     */
    @GetMapping()
    public ResponseEntity<Prices> getPrice(@Validated ProductRequest request) {
        log.info("Fetching price for product: {}", request.getProductId());
        log.debug("Request details - Date: {}, ProductId: {}, BrandId: {}", request.getDate(), request.getProductId(), request.getBrandId());

        if (!Tools.isValidDateFormat(request.getDate())) {
            log.warn("Invalid date format: {}", request.getDate());
            return ResponseEntity.badRequest().build();
        }
        try {
            Prices prices = service.getProduct(request.getDate(), request.getProductId(), request.getBrandId());

            if (prices != null) {
                log.info("Price found for product: {}. Price: {}", request.getProductId(), prices.getPrice());
                return ResponseEntity.status(HttpStatus.OK).body(prices);
            } else {
                log.info("No price found for product: {}", request.getProductId());
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
        } catch (Exception e) {
            log.error("Error occurred while fetching price", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

