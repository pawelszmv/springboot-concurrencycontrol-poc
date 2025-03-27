package com.concurrencycontrol;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PostEndPointTest {

    // create Normal -> Simple Field constraint on DB
    private static final String URL = "http://localhost:8080/products/create?name=exampl1111eName";

    // Simulate multiple users making the same request
    private static final int NUM_THREADS = 20;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        AtomicInteger successCounter = new AtomicInteger(0);
        AtomicInteger errorCounter = new AtomicInteger(0);

        for (int i = 0; i < NUM_THREADS; i++) {
            executorService.submit(() -> {
                RestTemplate restTemplate = new RestTemplate();

                try {
                    ResponseEntity<String> response = restTemplate.getForEntity(URL, String.class);
                    log.info("Response: {}", response.getBody());
                    successCounter.incrementAndGet();
                } catch (Exception e) {
                    log.error("Error: {}", e.getMessage());
                    errorCounter.incrementAndGet();
                }

            });
        }

        executorService.shutdown();

        try {
            // Wait for all tasks to finish
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                log.warn("Executor did not terminate in the specified time.");
                executorService.shutdownNow();  // Force shutdown if not finished
            }
        } catch (InterruptedException e) {
            log.error("AwaitTermination interrupted: ", e);
            executorService.shutdownNow();
        }

        log.info("success: (" + successCounter.get() + " / " + NUM_THREADS + ") ");
        log.info("error: (" + errorCounter.get() + " / " + NUM_THREADS + ") ");
    }
}
