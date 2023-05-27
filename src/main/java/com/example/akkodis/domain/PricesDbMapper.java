package com.example.akkodis.domain;

import com.example.akkodis.domain.model.Prices;
import com.example.akkodis.infraestructure.model.PricesEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PricesDbMapper {

  default Prices toDomain(PricesEntity entity) {
    return Prices.builder()
        .brandId(entity.getBrand_Id())
        .priceList(entity.getPrice_List())
        .price(entity.getPrice())
        .curr(entity.getCurr())
        .endDate(entity.getEnd_Date())
        .startDate(entity.getStart_Date())
        .priority(entity.getPriority())
        .productId(entity.getProduct_Id())
        .build();
  }
}
