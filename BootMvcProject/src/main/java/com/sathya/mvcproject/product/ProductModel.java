package com.sathya.mvcproject.product;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductModel {

 private String name;
 private double price;
 private int quantity;
 private String brand;
 private String madeIn;
}
