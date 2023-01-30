package com.example.amaris.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prices {
    private int BRAND_ID;

    private int PRICE_LIST;

    private int PRODUCT_ID;

    private float PRICE;

    private LocalDateTime START_DATE;

    private LocalDateTime END_DATE;
    @JsonIgnore
    private String CURR;

    private int PRIORITY;

}
