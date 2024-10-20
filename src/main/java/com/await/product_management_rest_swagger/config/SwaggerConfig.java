package com.await.product_management_rest_swagger.config; // Package where the configuration class is located

import io.swagger.v3.oas.annotations.OpenAPIDefinition; // Importing annotation to define global OpenAPI settings
import io.swagger.v3.oas.annotations.info.Info; // Importing annotation to define API metadata
import org.springframework.context.annotation.Configuration; // Importing Configuration annotation to mark this as a Spring configuration class

@Configuration // Annotation indicating this is a Spring configuration class
@OpenAPIDefinition( // Annotation to define the OpenAPI specification for the project
    info = @Info( // Info section to provide API metadata
        title = "Product Management API", // Title of the API
        version = "1.0" // Version of the API
    )
)
public class SwaggerConfig {
    // This class is used to configure Swagger/OpenAPI documentation for the API.
    // It provides basic information like the title and version of the API.
}
