package com.concurrencycontrol.infrastructure.api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.concurrencycontrol.application.services.SyncProductService;

@RestController
@RequestMapping("/sync-products")
@RequiredArgsConstructor
public class SyncProductController {

    private final SyncProductService syncProductService;

    @GetMapping("/buy")
    public ResponseEntity<String> buyProductSynchronized(@RequestParam Integer quantity, @RequestParam Long id) {
        syncProductService.buyProductSynchronized(id, quantity);
        return ResponseEntity.ok("Sync Product bought successfully");
    }

}
