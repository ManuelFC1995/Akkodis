package com.example.akkodis.infraestructure.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceKeyEntity {

    private int price_List;

    private int product_Id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriceKeyEntity priceKey = (PriceKeyEntity) o;
        return price_List == priceKey.price_List && product_Id == priceKey.product_Id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price_List, product_Id);
    }
}
