package com.await.product_management_rest_swagger; // Package where the application class is located

import org.springframework.boot.SpringApplication; // Importing SpringApplication class for launching the application
import org.springframework.boot.autoconfigure.SpringBootApplication; // Importing annotation for automatic Spring Boot configuration

@SpringBootApplication // Annotation indicating this is a Spring Boot application
public class ProductManagementRestSwaggerApplication {

	public static void main(String[] args) {
		// Launching the Spring Boot application
		SpringApplication.run(ProductManagementRestSwaggerApplication.class, args);
	}

}
