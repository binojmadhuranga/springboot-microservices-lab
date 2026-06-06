package com.example.practical.orderservice.controller;

import com.example.practical.orderservice.client.ProductClient;
import com.example.practical.orderservice.dto.OrderResponseDTO;
import com.example.practical.orderservice.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final ProductClient productClient;

    @GetMapping("/{id}")
    public OrderResponseDTO getOrder(
            @PathVariable Long id
    ) {

        ProductDTO product =
                productClient.getProduct(id);

        return new OrderResponseDTO(
                product.id(),
                product.name(),
                product.price()
        );
    }
}