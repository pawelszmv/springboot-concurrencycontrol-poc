package com.concurrencycontrol.infrastructure.api.controllers;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.concurrencycontrol.application.services.ProductService;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/buy")
    public ResponseEntity<String> buyProductNormal(@RequestParam Integer quantity, @RequestParam Long id) {
        productService.buyProductNormal(id, quantity);
        return ResponseEntity.ok("Product bought successfully");
    }

    @GetMapping("/create")
    public ResponseEntity<String> createProduct(@RequestParam String name) {

        try {
            productService.createProduct(name);
            return ResponseEntity.ok("Product created successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage()); // Custom error message
        }
    }
}
