package com.concurrencycontrol.infrastructure.api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.concurrencycontrol.application.services.VersionProductService;

@RestController
@RequestMapping("/version-products")
@RequiredArgsConstructor
public class VersionProductController
{

    private final VersionProductService productService;

    @GetMapping("/buy")
    public ResponseEntity<String> buyProduct(@RequestParam Integer quantity ,@RequestParam Long id ) {
        productService.buyProduct(id, quantity);
        return ResponseEntity.ok("Version Product bought successfully");
    }


}
