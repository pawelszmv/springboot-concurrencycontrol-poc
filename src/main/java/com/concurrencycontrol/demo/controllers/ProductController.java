package com.concurrencycontrol.demo.controllers;

import com.concurrencycontrol.demo.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController
{

    private final ProductService productService;

    @GetMapping("/buy")
    public ResponseEntity<String> buyProduct(@RequestParam Integer quantity ,@RequestParam Long id ) {
        productService.buyProduct(id, quantity);
        return ResponseEntity.ok("Product bought successfully");
    }


}
