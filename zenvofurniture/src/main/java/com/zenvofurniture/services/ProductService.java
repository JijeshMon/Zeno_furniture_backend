package com.zenvofurniture.services;

import java.util.List;

import com.zenvofurniture.dto.request.ProductRequest;

public interface ProductService {

	public String addProduct(ProductRequest productRequest);  
	public String editProduct(ProductRequest productRequest);  
	public String deleteProduct(Long productId);  
	public List<ProductRequest> getAllProducts();
}
