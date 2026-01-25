package com.example.productcatalog.config;

import com.example.productcatalog.model.Category;
import com.example.productcatalog.model.Product;
import com.example.productcatalog.repository.CategoryRepository;
import com.example.productcatalog.repository.ProductRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Profile("!test")
@Component
public class DatabaseSeeder implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public DatabaseSeeder(CategoryRepository categoryRepository,
                          ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) {

        if (categoryRepository.count() == 0) {

            Category electronics = new Category("Electronics");
            Category books = new Category("Books");

            categoryRepository.save(electronics);
            categoryRepository.save(books);

            productRepository.save(
                    new Product("Smartphone", "Android smartphone",
                            new BigDecimal("15000"), electronics));

            productRepository.save(
                    new Product("Laptop", "15-inch laptop",
                            new BigDecimal("55000"), electronics));

            productRepository.save(
                    new Product("Headphones", "Wireless headphones",
                            new BigDecimal("3000"), electronics));

            productRepository.save(
                    new Product("Spring Boot Book", "Backend development guide",
                            new BigDecimal("800"), books));

            productRepository.save(
                    new Product("Java Fundamentals", "Beginner Java book",
                            new BigDecimal("600"), books));
        }
    }
}
