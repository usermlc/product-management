package com.await.product_management_rest_swagger.controller; // Package where the controller class is located

import com.await.product_management_rest_swagger.model.Product; // Importing the Product model class
import com.await.product_management_rest_swagger.service.ProductService; // Importing the ProductService for business logic
import io.swagger.v3.oas.annotations.Operation; // Importing Swagger annotation for documenting API operations
import io.swagger.v3.oas.annotations.tags.Tag; // Importing Swagger annotation to tag the controller class for grouping related APIs
import org.springframework.data.domain.Page; // Importing Page for paginated result handling
import org.springframework.data.domain.PageRequest; // Importing PageRequest to create pagination parameters
import org.springframework.data.domain.Pageable; // Importing Pageable for pagination
import org.springframework.http.HttpStatus; // Importing HttpStatus for defining HTTP response statuses
import org.springframework.http.ResponseEntity; // Importing ResponseEntity to wrap HTTP responses
import org.springframework.web.bind.annotation.*; // Importing Spring MVC annotations for RESTful API handling

import java.math.BigDecimal; // Importing BigDecimal for price representation
import java.util.List; // Importing List for returning collections of products
import java.util.Optional; // Importing Optional for handling possible null values in findById

@RestController // Annotation indicating that this class is a RESTful controller
@RequestMapping("/api/products") // Base URL for all product-related endpoints
@Tag(name = "Product Management", description = "Operations related to products") // Swagger annotation to group related API endpoints
public class ProductController {

    private final ProductService productService; // Declaring a ProductService to handle business logic

    // Constructor to inject ProductService dependency
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Endpoint to get all products, with optional filters for category and price, and paginated results
    @GetMapping
    @Operation(summary = "Get all products", description = "Returns a list of products with optional filters") // Swagger documentation for the API
    public ResponseEntity<List<Product>> getAllProducts(
        @RequestParam(defaultValue = "0") int page, // Default page number
        @RequestParam(defaultValue = "10") int size, // Default page size
        @RequestParam(required = false) Long categoryId, // Optional filter by category ID
        @RequestParam(required = false) BigDecimal minPrice, // Optional filter by minimum price
        @RequestParam(required = false) BigDecimal maxPrice) { // Optional filter by maximum price

        Pageable pageable = PageRequest.of(page, size); // Create Pageable object with page and size parameters
        Page<Product> productPage = productService.findFilteredProducts(categoryId, minPrice, maxPrice, pageable); // Fetch filtered products using ProductService

        if (productPage.hasContent()) { // Check if there are products in the result
            return ResponseEntity.ok(productPage.getContent()); // Return the list of products with HTTP 200 OK
        } else {
            return ResponseEntity.badRequest().build(); // Return HTTP 400 Bad Request if no products found
        }
    }

    // Endpoint to get a product by its ID
    @GetMapping("/{id}")
    @Operation(summary = "Get product by ID", description = "Returns a product by its ID") // Swagger documentation for the API
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> productOptional = productService.findById(id); // Fetch product by ID
        return productOptional.map(ResponseEntity::ok) // If product is found, return it with HTTP 200 OK
            .orElseGet(() -> ResponseEntity.notFound().build()); // Otherwise, return HTTP 404 Not Found
    }

    // Endpoint to create a new product
    @PostMapping
    @Operation(summary = "Create a new product", description = "Adds a new product to the inventory") // Swagger documentation for the API
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.save(product); // Save the new product using ProductService
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct); // Return the created product with HTTP 201 Created
    }

    // Endpoint to update an existing product
    @PutMapping("/{id}")
    @Operation(summary = "Update an existing product", description = "Updates the product by its ID") // Swagger documentation for the API
    public ResponseEntity<Void> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        product.setId(id); // Set the ID of the product to ensure it's updated

        return ResponseEntity.status(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS).build(); // Placeholder response, you may replace with actual logic
    }

    // Endpoint to delete a product by its ID
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a product", description = "Removes a product by its ID") // Swagger documentation for the API
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        Optional<Product> productOptional = productService.findById(id); // Fetch product by ID
        if (productOptional.isPresent()) { // If product is found
            productService.deleteById(id); // Delete the product
            return ResponseEntity.noContent().build(); // Return HTTP 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // Return HTTP 404 Not Found if product does not exist
        }
    }
}
