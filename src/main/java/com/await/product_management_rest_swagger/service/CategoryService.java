package com.await.product_management_rest_swagger.service; // Package where the service class is located

import com.await.product_management_rest_swagger.model.Category; // Importing the Category model class
import com.await.product_management_rest_swagger.repository.CategoryRepository; // Importing the CategoryRepository interface
import java.util.List; // Importing List for returning collections of categories
import java.util.Optional; // Importing Optional for handling possible null values in findById
import org.springframework.stereotype.Service; // Importing Service annotation to define this as a service component

@Service // Annotation indicating this is a service class managed by Spring
public class CategoryService {

    // Declaring a repository to interact with the Category database
    private final CategoryRepository categoryRepository;

    // Constructor to inject CategoryRepository dependency
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // Method to find and return all categories
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    // Method to find a category by its ID, returning an Optional in case it's not found
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    // Method to save a new or updated category to the repository
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    // Method to delete a category from the repository by its ID
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}
