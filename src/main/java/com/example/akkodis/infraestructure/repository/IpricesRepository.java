package com.example.akkodis.infraestructure.repository;

import com.example.akkodis.infraestructure.model.PriceKeyEntity;
import com.example.akkodis.infraestructure.model.PricesEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface IpricesRepository extends JpaRepository<PricesEntity, PriceKeyEntity> {
    @Query(value = "SELECT  * FROM PRICES as p WHERE p.Product_Id = :ProductId AND p.Brand_Id = :BrandId",
        nativeQuery = true)
    ArrayList<PricesEntity> findByBrandIdAndProductId(@Param("ProductId") int productId,
                                                      @Param("BrandId") int brandId);
}
