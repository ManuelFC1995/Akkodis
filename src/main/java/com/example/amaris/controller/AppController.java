package com.example.amaris.controller;

import com.example.amaris.model.Prices;
import com.example.amaris.service.PriceService;
import com.example.amaris.utils.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.Utilities;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

@RestController
@RequestMapping("/prices")
public class AppController {
    @Autowired
    PriceService priceService;
    @GetMapping()
    public ResponseEntity<Prices> getPrice(
             @RequestParam(name = "StartDate") String startDate,
             @RequestParam(name = "productId") int productId,
             @RequestParam(name = "BrandId") int brandId) {
        System.out.println(startDate);

        Boolean si =Tools.VerificationDateFormatt(startDate);
System.out.println(si);
    return new ResponseEntity<Prices>(new Prices(),new HttpHeaders(), HttpStatus.OK);
    }

}
