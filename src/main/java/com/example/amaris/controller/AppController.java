package com.example.amaris.controller;

import com.example.amaris.exceptions.RecordNotFoundException;
import com.example.amaris.model.Prices;
import com.example.amaris.service.PriceService;
import com.example.amaris.utils.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/prices")
public class AppController {
    @Autowired
    PriceService priceService;

    @GetMapping()
    public ResponseEntity<Prices> getPrice(
            @RequestParam(name = "Date") String Date,
            @RequestParam(name = "productId") int productId,
            @RequestParam(name = "BrandId") int brandId) {

        //Nos traemos la lista ordenada por el campo priority
        Prices prices = priceService.getPrice(Date, productId, brandId);

            //devolvemos solo el primero en prioridad
            return new ResponseEntity<Prices>(prices, new HttpHeaders(), HttpStatus.OK);

    }

}
