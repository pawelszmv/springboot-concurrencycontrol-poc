package com.concurrencycontrol.infrastructure.api.controllers;

import lombok.RequiredArgsConstructor;
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

}
