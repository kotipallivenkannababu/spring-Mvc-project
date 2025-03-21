package com.sathya.mvcproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sathya.mvcproject.entity.ProductEntity;
import com.sathya.mvcproject.product.ProductModel;
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long>{
 
}
