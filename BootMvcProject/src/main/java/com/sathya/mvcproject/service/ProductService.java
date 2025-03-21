package com.sathya.mvcproject.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sathya.mvcproject.entity.ProductEntity;
import com.sathya.mvcproject.product.ProductModel;
import com.sathya.mvcproject.repository.ProductRepository;

@Service
public class ProductService {

    private static final double totalAmount = 0;
	@Autowired
    private ProductRepository productRepository;

    
    public void saveProductData(ProductModel productModel) {
        double price = productModel.getPrice();
        double totalAmount = productModel.getPrice()*productModel.getQuantity();
        double taxAmount = totalAmount * 0.18;

        // ✅ Convert ProductModel → ProductEntity
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(productModel.getName());
        productEntity.setPrice(productModel.getPrice());
        productEntity.setQuantity(productModel.getQuantity());
        productEntity.setBrand(productModel.getBrand());
        productEntity.setMadeIn(productModel.getMadeIn());
        productEntity.setTaxamount(taxAmount);
        productEntity.setTotalAmount(totalAmount+taxAmount);
        productEntity.setCreatedAt(LocalDateTime.now());
        productEntity.setCreatedBy(System.getProperty("user.name"));

        // ✅ Save to Database
        productRepository.save(productEntity);
        
        
    }
     
    public List<ProductEntity> getAllProducts()
    {
    	List<ProductEntity> products=productRepository.findAll();
    	return products;
    }
  
	public ProductEntity getProductById(Long id) {
		ProductEntity product=productRepository.findById(id).get();
    	return product;
		
	}
	public void deleteProductById(Long id) {
		productRepository.deleteById(id);
		
	}
	public void updateProduct(Long id,ProductModel productModel) {
		ProductEntity productEntity = productRepository.findById(id).orElseThrow();
        //Optional<ProductEntity> existingProductOpt = productRepository.findById(updatedProduct.getId());
            
            productEntity.setName(productModel.getName());
            productEntity.setPrice(productModel.getPrice());
            productEntity.setQuantity(productModel.getQuantity());
            productEntity.setMadeIn(productModel.getMadeIn());
            productEntity.setBrand(productModel.getBrand());
            
            double price = productModel.getPrice();
            double totalAmount =productModel.getPrice()*productModel.getQuantity();
            double taxAmount = totalAmount * 0.18;
            
            productEntity.setTaxamount(taxAmount);
            productEntity.setTotalAmount(totalAmount+taxAmount);
            productEntity.setCreatedAt(LocalDateTime.now());
            productEntity.setCreatedBy(System.getProperty("user.name"));

            productRepository.save(productEntity);
    }
}
