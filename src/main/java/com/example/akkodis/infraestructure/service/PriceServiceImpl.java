package com.example.akkodis.infraestructure.service;

import com.example.akkodis.infraestructure.model.PricesEntity;
import com.example.akkodis.infraestructure.repository.IpricesRepository;
import com.example.akkodis.application.utils.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Comparator;



@Service
public class PriceServiceImpl implements PriceService {
    @Autowired
    IpricesRepository repository;

    @Override
    public PricesEntity getPriceByFilters(String date, int productId, int brandId) {
        return repository.findByBrandIdAndProductId(productId, brandId)
            .stream()
            .filter(p -> Tools.convertToDate(p.getEnd_Date()).isAfter(Tools.convertToDate(date))
                && Tools.convertToDate(p.getStart_Date()).isBefore(Tools.convertToDate(date)))
            .min(Comparator.naturalOrder())
            .orElse(null);
    }
}
