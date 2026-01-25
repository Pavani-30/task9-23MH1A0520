package com.example.productcatalog.service;

import com.example.productcatalog.dto.CategoryRequestDTO;
import com.example.productcatalog.dto.CategoryResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    public CategoryResponseDTO createCategory(CategoryRequestDTO dto) {
        return new CategoryResponseDTO(1L, dto.getName());
    }

    public List<CategoryResponseDTO> getAllCategories() {
        return List.of();
    }

    public CategoryResponseDTO getCategoryById(Long id) {
        return new CategoryResponseDTO(id, "Sample Category");
    }

    public CategoryResponseDTO updateCategory(Long id, CategoryRequestDTO dto) {
        return new CategoryResponseDTO(id, dto.getName());
    }

    public void deleteCategory(Long id) {
    }
}
