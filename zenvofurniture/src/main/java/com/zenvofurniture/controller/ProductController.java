package com.zenvofurniture.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.zenvofurniture.dto.request.ProductRequest;
import com.zenvofurniture.services.ProductService;

import lombok.AllArgsConstructor;
import java.util.List;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {
    
    private final ProductService productService;
    
    @PostMapping("/addProduct")
    public ResponseEntity<?> addProduct(@RequestBody ProductRequest productRequest) {
        try {
            String result = productService.addProduct(productRequest);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error: " + e.getMessage());
        }
    }
    
    @PutMapping("/editProduct")
    public ResponseEntity<?> editProduct(@RequestBody ProductRequest productRequest) {
        try {
            String result = productService.editProduct(productRequest);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error: " + e.getMessage());
        }
    }
    
    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        try {
            String result = productService.deleteProduct(id);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error: " + e.getMessage());
        }
    }
    
    @GetMapping("/getAllProducts")
    public ResponseEntity<?> getAllProducts() {
        try {
            List<ProductRequest> products = productService.getAllProducts();
            if (products == null) {
                return ResponseEntity.ok(List.of());
            }
            return ResponseEntity.ok(products);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error fetching products: " + e.getMessage());
        }
    }
    
    
}