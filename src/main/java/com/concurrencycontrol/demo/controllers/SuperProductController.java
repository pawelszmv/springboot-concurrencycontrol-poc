package com.concurrencycontrol.demo.controllers;

import com.concurrencycontrol.demo.services.SuperProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/super-products")
@RequiredArgsConstructor
public class SuperProductController {

    private final SuperProductService productService;

    @GetMapping("/buy")
    public ResponseEntity<String> buyProduct(@RequestParam Integer quantity , @RequestParam Long id ) {
        productService.buyProduct(id, quantity);
        return ResponseEntity.ok("Product bought successfully");
    }
}
