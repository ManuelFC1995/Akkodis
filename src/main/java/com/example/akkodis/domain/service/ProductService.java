package com.example.akkodis.domain.service;

import com.example.akkodis.domain.PricesDbMapper;
import com.example.akkodis.domain.model.Prices;
import com.example.akkodis.infraestructure.model.PricesEntity;
import com.example.akkodis.infraestructure.service.PriceService;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
  private final PriceService priceService;
  private final PricesDbMapper pricesDbMapper;

  public ProductService(PriceService priceService, PricesDbMapper pricesDbMapper) {
    this.priceService = priceService;
    this.pricesDbMapper = pricesDbMapper;
  }

  /**
   * Obtiene el precio de un producto en base a la fecha, el identificador del producto y el identificador de la marca.
   *
   * @param date      Fecha de aplicación del precio
   * @param productId Identificador del producto
   * @param brandId   Identificador de la marca
   * @return Objeto Prices con la información del precio del producto
   */
  public Prices getProduct(String date, int productId, int brandId) {
    PricesEntity entity = priceService.getPriceByFilters(date, productId, brandId);
    return (entity != null) ? pricesDbMapper.toDomain(entity) : null;
  }
}