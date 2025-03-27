package com.concurrencycontrol.infrastructure.api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.concurrencycontrol.application.services.LockProductService;

@RestController
@RequestMapping("/lock-products")
@RequiredArgsConstructor
public class LockProductController {

    private final LockProductService lockProductService;

    @GetMapping("/buy")
    public ResponseEntity<String> buyProduct(@RequestParam Integer quantity, @RequestParam Long id) {
        lockProductService.buyProduct(id, quantity);
        return ResponseEntity.ok("Lock Product bought successfully");
    }
}
