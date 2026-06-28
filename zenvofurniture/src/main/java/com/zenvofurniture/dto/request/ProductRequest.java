package com.zenvofurniture.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
  
    private Long id;   
    private String productName;
    private String productDescription;
    private String productType;
    private String productImage;
}