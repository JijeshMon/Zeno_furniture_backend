package com.zenvofurniture.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zenvofurniture.dto.request.ProductRequest;
import com.zenvofurniture.entity.ProductEntity;
import com.zenvofurniture.repository.ProductRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductServiceImpl  implements ProductService{
private final ProductRepository productRepository;

@Override
	public String addProduct(ProductRequest productRequest) {
		ProductEntity productEntity = new ProductEntity();
		productEntity.setProductName(productRequest.getProductName());
		productEntity.setProductType(productRequest.getProductType());
		productEntity.setProductDescription(productRequest.getProductDescription());
		productEntity.setProductImage(productRequest.getProductImage());
		productRepository.save(productEntity);
		return "product added";
	}
@Override
public String editProduct(ProductRequest productRequest) {
    try {
        Optional<ProductEntity> existingOpt = productRepository.findById(productRequest.getId());
        if (existingOpt.isPresent()) {
            ProductEntity entity = existingOpt.get();
            entity.setProductName(productRequest.getProductName());
            entity.setProductDescription(productRequest.getProductDescription());
            entity.setProductType(productRequest.getProductType());
            entity.setProductImage(productRequest.getProductImage());
            productRepository.save(entity);
            return "Product updated successfully";
        }
        return "Product not found";
    } catch (Exception e) {
        e.printStackTrace();
        return "Error updating product: " + e.getMessage();
    }
}

@Override
public String deleteProduct(Long id) {
    try {
        productRepository.deleteById(id);
        return "Product deleted successfully";
    } catch (Exception e) {
        e.printStackTrace();
        return "Error deleting product: " + e.getMessage();
    }
}

@Override
public List<ProductRequest> getAllProducts() {
    List<ProductRequest> productRequests = new ArrayList<>();
    try {
        List<ProductEntity> products = productRepository.findAll();
        for (ProductEntity entity : products) {
            ProductRequest request = new ProductRequest();
            request.setId(entity.getId());
            request.setProductName(entity.getProductName());
            request.setProductDescription(entity.getProductDescription());
            request.setProductType(entity.getProductType());
            request.setProductImage(entity.getProductImage());
            productRequests.add(request);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return productRequests;
}
}
