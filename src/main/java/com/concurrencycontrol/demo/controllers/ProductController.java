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

    @GetMapping("/buy-normal")
    public ResponseEntity<String> buyProductNormal(@RequestParam Integer quantity ,@RequestParam Long id ) {
        productService.buyProductNormal(id, quantity);
        return ResponseEntity.ok("Product bought successfully");
    }

    @GetMapping("/buy-synchronized")
    public ResponseEntity<String> buyProductSynchronized(@RequestParam Integer quantity ,@RequestParam Long id ) {
        productService.buyProductSynchronized(id, quantity);
        return ResponseEntity.ok("Product bought successfully");
    }


}
