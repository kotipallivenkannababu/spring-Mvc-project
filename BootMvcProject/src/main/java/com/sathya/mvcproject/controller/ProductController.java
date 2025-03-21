package com.sathya.mvcproject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sathya.mvcproject.entity.ProductEntity;
import com.sathya.mvcproject.product.ProductModel;
import com.sathya.mvcproject.service.ProductService;

import jakarta.validation.Valid;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/productform")
    public String getForm(Model model) {
    	
    	
        ProductModel product = new ProductModel();
        product.setMadeIn("India");
        model.addAttribute("product", product);
        return "add-product"; 
    }
    
    
    @GetMapping("/getAllProducts")
    public String getAllProducts(Model model)
    {
    	List<ProductEntity> products=productService.getAllProducts();
    	model.addAttribute("products",products);
    	return "product-list";
    }
    @GetMapping("/product/{id}")
    public String getProductById(@PathVariable Long id, Model model) 
    {
        ProductEntity product = productService.getProductById(id);
       model.addAttribute("product", product);
            return "productById";
    }
    @GetMapping("deleteproduct/{id}")
    public String deleteproductById(@PathVariable("id") Long id, Model model)
    {
    	productService.deleteProductById(id);
		return "redirect:/getAllProducts";	
    } 
    @GetMapping("/editProduct/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        ProductEntity productEntity = productService.getProductById(id);
        model.addAttribute("product", productEntity);
            return "edit-product";
        } 

    @PostMapping("/updateProduct/{id}")
    public String updateProduct(@PathVariable Long id ,@ModelAttribute ProductModel productModel) {
        productService.updateProduct(id,productModel);
        return "redirect:/getAllProducts"; 
    }
    
    @PostMapping("/product/saveproduct")
    public String saveProductData(@Valid @ModelAttribute("product") ProductModel productModel, BindingResult bindingResult) {
    	if(bindingResult.hasErrors()) {
    		return "add-product";
    	}
        productService.saveProductData(productModel);
        return "success"; 
    }
   
}
