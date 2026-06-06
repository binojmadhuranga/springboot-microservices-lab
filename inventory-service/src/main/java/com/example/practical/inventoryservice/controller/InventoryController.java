package com.example.practical.inventoryservice.controller;

import com.example.practical.inventoryservice.dto.InventoryDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @GetMapping("/{productId}")
    public InventoryDTO getInventory(
            @PathVariable Long productId
    ) {
        return new InventoryDTO(
                productId,
                25
        );
    }
}