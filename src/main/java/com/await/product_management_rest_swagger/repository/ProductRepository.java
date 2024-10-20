package com.await.product_management_rest_swagger.repository; // Package where the repository interface is located

import com.await.product_management_rest_swagger.model.Product; // Importing the Product model class
import org.springframework.data.jpa.repository.JpaRepository; // Importing JpaRepository to provide basic CRUD operations
import org.springframework.data.jpa.repository.JpaSpecificationExecutor; // Importing JpaSpecificationExecutor for building dynamic queries with specifications

// Repository interface for managing Product entities in the database
public interface ProductRepository extends JpaRepository<Product, Long>,
    JpaSpecificationExecutor<Product> {
    // This interface inherits methods for CRUD operations (from JpaRepository)
    // and dynamic query execution using Specifications (from JpaSpecificationExecutor)
}
