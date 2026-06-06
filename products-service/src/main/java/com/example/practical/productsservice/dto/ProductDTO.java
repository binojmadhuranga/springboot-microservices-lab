package com.example.practical.productsservice.dto;


public record ProductDTO(
        Long id,
        String name,
        Double price
) {}