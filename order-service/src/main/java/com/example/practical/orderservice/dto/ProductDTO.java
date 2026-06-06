package com.example.practical.orderservice.dto;

public record ProductDTO(
        Long id,
        String name,
        Double price
) {}