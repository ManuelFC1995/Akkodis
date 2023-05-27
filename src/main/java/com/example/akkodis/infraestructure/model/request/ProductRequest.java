package com.example.akkodis.infraestructure.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {

   private String date;
   private int productId;
   private int brandId;
}
