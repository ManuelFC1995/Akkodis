package com.example.amaris.service;

import com.example.amaris.model.Prices;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class PriceService {

public Prices getPrice(String startDate, int productId, int brandId){

    return new Prices();


}
}
