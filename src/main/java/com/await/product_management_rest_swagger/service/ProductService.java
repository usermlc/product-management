package com.await.product_management_rest_swagger.service; // Package where the service class is located

import com.await.product_management_rest_swagger.model.Product; // Importing the Product model class
import com.await.product_management_rest_swagger.repository.ProductRepository; // Importing the ProductRepository interface
import com.await.product_management_rest_swagger.specification.ProductSpecification; // Importing product specifications for filtering
import java.math.BigDecimal; // Importing BigDecimal for price representation
import java.util.List; // Importing List for returning collections of products
import java.util.Optional; // Importing Optional for handling possible null values in findById
import org.springframework.data.domain.Page; // Importing Page for handling paginated results
import org.springframework.data.domain.Pageable; // Importing Pageable for pagination
import org.springframework.data.jpa.domain.Specification; // Importing Specification for building dynamic query filters
import org.springframework.stereotype.Service; // Importing Service annotation to define this as a service component

@Service // Annotation indicating this is a service class managed by Spring
public class ProductService {

    // Declaring a repository to interact with the Product database
    private final ProductRepository productRepository;

    // Constructor to inject ProductRepository dependency
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Method to find and return all products
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    // Method to find a product by its ID, returning an Optional in case it's not found
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    // Method to save a new or updated product to the repository
    public Product save(Product product) {
        return productRepository.save(product);
    }

    // Method to delete a product from the repository by its ID
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    // Method to find products with filters (category, price range) and paginate the results
    public Page<Product> findFilteredProducts(Long categoryId, BigDecimal minPrice, BigDecimal maxPrice, Pageable pageable) {
        // Create a specification for filtering products by category and price
        Specification<Product> spec = Specification.where(ProductSpecification.hasCategory(categoryId))
            .and(ProductSpecification.priceBetween(minPrice, maxPrice));

        // Return the filtered and paginated list of products
        return productRepository.findAll(spec, pageable);
    }
}
