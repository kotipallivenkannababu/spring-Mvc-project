package com.sathya.mvcproject.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")  
public class ProductEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    private String name;
    private double price;
    private int quantity;
    private String brand;
    private String madeIn;
    private double totalAmount;
    private double taxamount;
    private LocalDateTime createdAt;
    private String createdBy;
}
