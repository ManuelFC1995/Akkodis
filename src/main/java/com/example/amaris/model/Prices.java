package com.example.amaris.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "prices")
@IdClass(value = PriceKey.class)
public class Prices implements Serializable, Comparable<Prices> {
    @Column(name="BRAND_ID")
    private int BRAND_ID;
    @Id
    @Column(name="PRICE_LIST")
    private int PRICE_LIST;
    @Id
    @Column(name="PRODUCT_ID")
    private int PRODUCT_ID;

    @Column(name="PRICE")
    private float PRICE;

    @Column(name="START_DATE")
    private String START_DATE;
    @Column(name="END_DATE")
    private String END_DATE;
    @JsonIgnore
    @Column(name="CURR")
    private String CURR;
    @Column(name="PRIORITY")
    private int PRIORITY;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prices prices = (Prices) o;
        return PRICE_LIST == prices.PRICE_LIST && PRODUCT_ID == prices.PRODUCT_ID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(PRICE_LIST, PRODUCT_ID);
    }


    @Override
    public int compareTo(Prices price1) {
        return this.getPRIORITY()-price1.getPRIORITY();
    }
}
