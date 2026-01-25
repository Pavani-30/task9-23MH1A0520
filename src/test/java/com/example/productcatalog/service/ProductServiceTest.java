package com.example.productcatalog.service;

import com.example.productcatalog.model.Category;
import com.example.productcatalog.model.Product;
import com.example.productcatalog.repository.CategoryRepository;
import com.example.productcatalog.repository.ProductRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;
    

    @BeforeEach
    void setUp() {
        productRepository.deleteAll();
        categoryRepository.deleteAll();

        Category category = categoryRepository.save(new Category("Electronics"));

        productRepository.save(
                new Product("Phone", "Android phone",
                        new BigDecimal("15000"), category)
        );
    }

    @Test
    void shouldReturnAllProducts() {
        List<?> products = productService.getAllProducts(0, 10);
        assertEquals(1, products.size());
    }
}
