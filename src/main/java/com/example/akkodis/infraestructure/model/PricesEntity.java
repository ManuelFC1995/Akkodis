package com.example.akkodis.infraestructure.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "prices")
@IdClass(value = PriceKeyEntity.class)
public class PricesEntity implements Serializable, Comparable<PricesEntity> {
  @Column(name = "BRAND_ID")
  private int brand_Id;
  @Id
  @Column(name = "PRICE_LIST")
  private int price_List;
  @Id
  @Column(name = "PRODUCT_ID")
  private int product_Id;
  @Column(name = "PRICE")
  private float price;
  @Column(name = "START_DATE")
  private String start_Date;
  @Column(name = "END_DATE")
  private String end_Date;
  @JsonIgnore
  @Column(name = "CURR")
  private String curr;
  @Column(name = "PRIORITY")
  private int priority;


  @Override
  public boolean equals(Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
    PricesEntity prices = (PricesEntity) o;
    return price_List == prices.price_List && product_Id == prices.product_Id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(price_List, product_Id);
  }


  @Override
  public int compareTo(PricesEntity price1) {
    return price1.getPriority() - this.getPriority();
  }
}
