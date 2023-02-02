package com.example.amaris.repository;

import com.example.amaris.model.PriceKey;
import com.example.amaris.model.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.Optional;

public interface IpricesRepository extends JpaRepository<Prices, PriceKey> {
    @Query(value = "SELECT  * FROM PRICES as p WHERE p.PRODUCT_ID = :PRODUCT_ID AND p.BRAND_ID = :BRAND_ID",
            nativeQuery = true)
    ArrayList<Prices> findByBrandIdAndProductId(@Param("PRODUCT_ID")int PRODUCT_ID, @Param("BRAND_ID") int BRAND_ID);

}
