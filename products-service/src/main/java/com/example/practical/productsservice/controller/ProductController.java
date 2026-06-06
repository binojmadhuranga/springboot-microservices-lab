package com.example.practical.productsservice.controller;

import com.example.practical.productsservice.dto.ProductDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping("/{id}")
    public ProductDTO getProduct(
            @PathVariable Long id
    ) {
        return new ProductDTO(
                id,
                "Laptop",
                1500.00
        );
    }
}