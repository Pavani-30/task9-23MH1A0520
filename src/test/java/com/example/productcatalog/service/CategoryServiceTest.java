package com.example.productcatalog.service;

import com.example.productcatalog.dto.CategoryResponseDTO;
import com.example.productcatalog.model.Category;
import com.example.productcatalog.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService;

    public CategoryServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnAllCategories() {

    Category category = new Category("Electronics");

    when(categoryRepository.findAll()).thenReturn(List.of(category));

    List<CategoryResponseDTO> categories = categoryService.getAllCategories();

    assertEquals(1, categories.size());
}

}
