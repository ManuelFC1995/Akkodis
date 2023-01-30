package com.example.amaris.controller;

import com.example.amaris.model.Prices;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

@RestController
@RequestMapping("/prices")
public class AppController {

    @GetMapping()
    public ResponseEntity<Prices> getPrice(@RequestParam(name = "StartDate") String startDate,
                                           @RequestParam(name = "productId") int productId,
                                           @RequestParam(name = "BrandId") int brandId)
            throws IOException, InterruptedException {
        System.out.println(startDate);


        return new ResponseEntity<Prices>(new Prices(),new HttpHeaders(), HttpStatus.OK);
    }

}
