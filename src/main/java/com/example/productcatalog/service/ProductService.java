package com.example.productcatalog.service;

import com.example.productcatalog.dto.ProductRequestDTO;
import com.example.productcatalog.dto.ProductResponseDTO;
import com.example.productcatalog.exception.ResourceNotFoundException;
import com.example.productcatalog.model.Category;
import com.example.productcatalog.model.Product;
import com.example.productcatalog.repository.CategoryRepository;
import com.example.productcatalog.repository.ProductRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository,
                          CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    public List<ProductResponseDTO> getAllProducts(int page, int size) {
        Page<Product> products =
                productRepository.findAll(PageRequest.of(page, size));

        return products
                .map(this::mapToResponseDTO)
                .getContent();
    }

    public ProductResponseDTO getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product not found with id " + id)
                );

        return mapToResponseDTO(product);
    }

    public ProductResponseDTO createProduct(ProductRequestDTO dto) {
        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Category not found with id " + dto.getCategoryId())
                );

        Product product = new Product();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setCategory(category);

        return mapToResponseDTO(productRepository.save(product));
    }

    public ProductResponseDTO updateProduct(Long id, ProductRequestDTO dto) {
        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product not found with id " + id)
                );

        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Category not found with id " + dto.getCategoryId())
                );

        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setCategory(category);

        return mapToResponseDTO(productRepository.save(product));
    }

    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product not found with id " + id)
                );

        productRepository.delete(product);
    }

    // DTO mapper
    private ProductResponseDTO mapToResponseDTO(Product product) {
        return new ProductResponseDTO(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getCategory().getName()
        );
    }
}
