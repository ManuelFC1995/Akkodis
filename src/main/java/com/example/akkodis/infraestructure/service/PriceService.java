package com.example.akkodis.infraestructure.service;

import com.example.akkodis.infraestructure.model.PricesEntity;

public interface PriceService {
  PricesEntity getPriceByFilters(String date, int productId, int brandId);
}
