package com.example.amaris.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceKey  {

    private int PRICE_LIST;

    private int PRODUCT_ID;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriceKey priceKey = (PriceKey) o;
        return PRICE_LIST == priceKey.PRICE_LIST && PRODUCT_ID == priceKey.PRODUCT_ID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(PRICE_LIST, PRODUCT_ID);
    }
}
