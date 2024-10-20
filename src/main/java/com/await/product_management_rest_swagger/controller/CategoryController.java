package com.await.product_management_rest_swagger.controller; // Package where the controller class is located

import com.await.product_management_rest_swagger.model.Category; // Importing the Category model class
import com.await.product_management_rest_swagger.service.CategoryService; // Importing the CategoryService for business logic
import java.util.Optional; // Importing Optional to handle possible null values in findById
import org.springframework.stereotype.Controller; // Importing the Controller annotation to mark this class as a web controller
import org.springframework.ui.Model; // Importing Model to pass data to the view
import org.springframework.web.bind.annotation.*; // Importing Spring MVC annotations for RESTful API handling

@Controller // Annotation indicating this class is a Spring MVC controller
@RequestMapping("/categories") // Base URL for all category-related endpoints
public class CategoryController {

    private final CategoryService categoryService; // Declaring a CategoryService to handle business logic

    // Constructor to inject CategoryService dependency
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // Method to list all categories and display them in the "categoryList" view
    @GetMapping
    public String listCategories(Model model) {
        model.addAttribute("categories", categoryService.findAll()); // Add the list of categories to the model
        return "categoryList"; // Return the view name to render the category list (e.g., categoryList.html)
    }

    // Method to display the form for adding a new category
    @GetMapping("/add")
    public String showAddCategoryForm(Model model) {
        model.addAttribute("category", new Category()); // Add a new empty Category object to the model
        return "categoryForm"; // Return the view name to render the category form (e.g., categoryForm.html)
    }

    // Method to handle form submission and create a new category
    @PostMapping
    public String createCategory(@ModelAttribute Category category) {
        categoryService.save(category); // Save the new category using CategoryService
        return "redirect:/categories"; // Redirect to the category list after saving
    }

    // Method to display the form for editing an existing category by ID
    @GetMapping("/edit/{id}")
    public String showEditCategoryForm(@PathVariable Long id, Model model) {
        Optional<Category> categoryOptional = categoryService.findById(id); // Fetch the category by ID
        model.addAttribute("category", categoryOptional.get()); // Add the category to the model for editing
        return "categoryForm"; // Return the view name to render the form for editing (e.g., categoryForm.html)
    }

    // Method to delete a category by its ID
    @PostMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Long id) {
        categoryService.deleteById(id); // Delete the category using CategoryService
        return "redirect:/categories"; // Redirect to the category list after deletion
    }
}
