package com.await.product_management_rest_swagger.repository; // Package where the repository interface is located

import com.await.product_management_rest_swagger.model.Category; // Importing the Category model class
import org.springframework.data.jpa.repository.JpaRepository; // Importing JpaRepository to provide basic CRUD operations

// Repository interface for managing Category entities in the database
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // This interface inherits methods for basic CRUD operations (create, read, update, delete)
    // from JpaRepository for the Category entity, with Long as the ID type
}
