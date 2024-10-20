package com.await.product_management_rest_swagger.specification; // Package where the specification class is located

import com.await.product_management_rest_swagger.model.Product; // Importing the Product model class
import java.math.BigDecimal; // Importing BigDecimal for price representation
import org.springframework.data.jpa.domain.Specification; // Importing Specification for building query conditions

public class ProductSpecification {

    // Method to filter products by category ID
    public static Specification<Product> hasCategory(Long categoryId) {
        return (root, query, criteriaBuilder) -> {
            // If categoryId is null, return all products (no filter)
            if (categoryId == null) {
                return criteriaBuilder.conjunction(); // Always true condition
            }
            // Filter products by the given category ID
            return criteriaBuilder.equal(root.get("category").get("id"), categoryId);
        };
    }

    // Method to filter products within a specific price range
    public static Specification<Product> priceBetween(BigDecimal minPrice, BigDecimal maxPrice) {
        return (root, query, criteriaBuilder) -> {
            // If both prices are null, return all products (no filter)
            if (minPrice == null && maxPrice == null) {
                return criteriaBuilder.conjunction(); // Always true condition
            }
            // If only minPrice is null, filter products below or equal to maxPrice
            else if (minPrice == null) {
                return criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice);
            }
            // If only maxPrice is null, filter products above or equal to minPrice
            else if (maxPrice == null) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice);
            }
            // If both prices are given, filter products between minPrice and maxPrice
            else {
                return criteriaBuilder.between(root.get("price"), minPrice, maxPrice);
            }
        };
    }
}
