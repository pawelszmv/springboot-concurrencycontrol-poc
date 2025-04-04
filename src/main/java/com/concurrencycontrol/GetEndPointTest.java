package com.concurrencycontrol;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class GetEndPointTest {

    // Normal -> No Locking applied
    private static final String URL = "http://localhost:8080/products/buy?id=1&quantity=1";

    // Memory level -> Pessimistic Locking
    // private static final String URL = "http://localhost:8080/sync-products/buy?id=1&quantity=1";

    // Database level -> Pessimistic Locking
    // private static final String URL = "http://localhost:8080/lock-products/buy?id=1&quantity=1";

    // Version product: Database level -> Optimistic Locking
    // private static final String URL = "http://localhost:8080/version-products/buy?id=1&quantity=1";

    // Simulate multiple users making the same request
    private static final int NUM_THREADS = 50;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_THREADS; i++) {
            executorService.submit(() -> {
                RestTemplate restTemplate = new RestTemplate();

                try {
                    ResponseEntity<String> response = restTemplate.getForEntity(URL, String.class);
                    log.info("Response: {}", response.getBody());
                } catch (Exception e) {
                    log.error("Error: {}", e.getMessage());
                }

            });
        }

        executorService.shutdown();
    }
}
