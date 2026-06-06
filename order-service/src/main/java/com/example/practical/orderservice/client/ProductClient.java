package com.example.practical.orderservice.client;

import com.example.practical.orderservice.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(
        name = "product-service",
        url = "http://localhost:8081"
)
public interface ProductClient {

    @GetMapping("/products/{id}")
    ProductDTO getProduct(
            @PathVariable Long id
    );
}