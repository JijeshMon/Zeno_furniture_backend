package com.zenvofurniture.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "product_name", nullable = false)
    private String productName;
    
    @Column(name = "product_description", columnDefinition = "TEXT")
    private String productDescription;
    
    @Column(name = "product_type")
    private String productType;
    
    @Column(name = "product_image", columnDefinition = "TEXT")  // Use TEXT for Base64 images
    private String productImage;
}