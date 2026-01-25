package com.example.productcatalog.service;

import com.example.productcatalog.dto.CategoryResponseDTO;
import com.example.productcatalog.model.Category;
import com.example.productcatalog.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import java.util.List;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;
    @InjectMocks
    private CategoryService categoryService;
    
    @Test
    void shouldReturnAllCategories() {
        Category category = new Category();
        category.setId(1L);
        category.setName("Electronics");

        when(categoryRepository.findAll())
                .thenReturn(List.of(category));

        List<CategoryResponseDTO> result =
                categoryService.getAllCategories();

        assertEquals(1, result.size());
    }
}

