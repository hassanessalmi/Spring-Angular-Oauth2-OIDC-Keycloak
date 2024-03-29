package com.example.inventoryservice.web;

import com.example.inventoryservice.entities.Product;
import com.example.inventoryservice.repository.ProductRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping ("/api")
public class ProductRestController {
    private ProductRepository productRepository;

    public ProductRestController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("/products")
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }
    @GetMapping("/products{id}")
    public Product getProductById(@PathVariable String id){
        return productRepository.findById(id).get();
    }
 @GetMapping("/auth")
    public Authentication authentication(Authentication authentication){
        return authentication;
 }

}
