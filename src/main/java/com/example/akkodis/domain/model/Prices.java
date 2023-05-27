package com.example.akkodis.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Prices {

  private int brandId;

  private int priceList;

  private int productId;

  private float price;

  private String startDate;

  private String endDate;

  private String curr;

  private int priority;
}
