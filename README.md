# Product Management REST API

## Overview
A **Spring Boot REST API** for managing products. It supports product creation, retrieval, updating, and deletion, with features like pagination and filtering.

## Features
- **CRUD operations** for products and categories.
- **Pagination** for efficient product listings.
- **Filtering** by category and price range.

## Usage

### Setup:
1. Clone the repository:
   ```bash
   git clone https://github.com/usermlc/product-management.git
   ```
2. Build and run the app:
   ```bash
   ./mvnw spring-boot:run
   ```
3. Access the API at `http://localhost:8080/api/products`.

### Key Endpoints:
- `GET /api/products`: Retrieve products with optional filters.
- `POST /api/products`: Add a new product.
- `GET /api/categories`: List all categories.

## File Structure
- `ProductController.java`: Handles product-related requests.
- `ProductService.java`: Business logic for products.
- `Product.java`: Product entity.

## License
This project is licensed under the MIT License. 
