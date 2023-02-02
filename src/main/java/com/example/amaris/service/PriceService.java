package com.example.amaris.service;

import com.example.amaris.model.PriceKey;
import com.example.amaris.model.Prices;
import com.example.amaris.repository.IpricesRepository;
import com.example.amaris.utils.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Service
public class PriceService {
    @Autowired
    IpricesRepository repository;

    public Prices getPrice(String date, int productId, int brandId) {

        //Buscamos las entidades por los campos BrandId y productId
        ArrayList<Prices> Allprice = repository.findByBrandIdAndProductId(productId, brandId);
        ArrayList<Prices> prices = new ArrayList<>();

        //Añadimos a la lista solo las que coincidan con la fecha requerida
        for (Prices p : Allprice) {
            if (Tools.covertDate(p.getEND_DATE()).isAfter(Tools.covertDate(date)) &&
                    Tools.covertDate(p.getSTART_DATE()).isBefore(Tools.covertDate(date))) {
                prices.add(p);
            }
            //Ordenamos por prioridad usando su comparador de la clase
            Collections.sort(prices);
        }
        if(prices.isEmpty()){
            return prices.get(0);
        }else{
            return new Prices();
        }

    }

}
