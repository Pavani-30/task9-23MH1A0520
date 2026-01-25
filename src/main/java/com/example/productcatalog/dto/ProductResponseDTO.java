package com.example.productcatalog.dto;

import java.math.BigDecimal;

public class ProductResponseDTO {

    private Long id;
    private String name;
    private BigDecimal price;
    private String categoryName;

    public ProductResponseDTO(Long id, String name, BigDecimal price, String categoryName) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.categoryName = categoryName;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public BigDecimal getPrice() { return price; }
    public String getCategoryName() { return categoryName; }
}
