package com.concurrencycontrol.infrastructure.api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.concurrencycontrol.application.services.UltraProductService;

@RestController
@RequestMapping("/ultra-products")
@RequiredArgsConstructor
public class UltraProductController
{

    private final UltraProductService productService;

    @GetMapping("/buy")
    public ResponseEntity<String> buyProduct(@RequestParam Integer quantity ,@RequestParam Long id ) {
        productService.buyProduct(id, quantity);
        return ResponseEntity.ok("Product bought successfully");
    }


}
