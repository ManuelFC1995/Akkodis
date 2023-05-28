package com.example.akkodis.infraestructure.repository;

import com.example.akkodis.infraestructure.model.PriceKeyEntity;
import com.example.akkodis.infraestructure.model.PricesEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface IpricesRepository extends JpaRepository<PricesEntity, PriceKeyEntity> {

    /**
     * Consulta para obtener una lista de PricesEntity filtrada por BrandId y ProductId.
     *
     * @param productId Identificador del producto
     * @param brandId   Identificador de la marca
     * @return ArrayList de PricesEntity que cumplen los criterios de búsqueda
     */
    @Query(value = "SELECT  * FROM PRICES as p WHERE p.Product_Id = :ProductId AND p.Brand_Id = :BrandId",
        nativeQuery = true)
    ArrayList<PricesEntity> findByBrandIdAndProductId(@Param("ProductId") int productId,
                                                      @Param("BrandId") int brandId);

}
