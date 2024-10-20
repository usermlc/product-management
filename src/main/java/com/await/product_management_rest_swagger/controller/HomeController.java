package com.await.product_management_rest_swagger.controller; // Package where the controller class is located

import org.springframework.stereotype.Controller; // Importing the Controller annotation to mark this class as a web controller
import org.springframework.ui.Model; // Importing Model to pass data to the view
import org.springframework.web.bind.annotation.GetMapping; // Importing GetMapping to map HTTP GET requests

@Controller // Annotation indicating this class is a Spring MVC controller
public class HomeController {

    // Method to handle GET requests to the "/main" URL and return the "main" view
    @GetMapping("/main") // Mapping HTTP GET requests to the "/main" URL
    public String mainPage(Model model) {
        // Returns the name of the view to render (in this case, "main")
        return "main"; // "main" refers to the view template (e.g., main.html in Thymeleaf or JSP)
    }
}
