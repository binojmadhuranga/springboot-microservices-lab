package com.example.practical.orderservice.dto;

public record OrderResponseDTO(
        Long productId,
        String productName,
        Double price
) {}