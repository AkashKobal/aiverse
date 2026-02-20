package com.aiverse.aiverse.services;

import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class ModelRouterService {

    private final List<ModelService> services;
    private final ExecutorService executor =
            Executors.newFixedThreadPool(10);

    public ModelRouterService(List<ModelService> services) {
        this.services = services;
    }

    public Map<String, String> askAll(String message) {

        Map<String, CompletableFuture<String>> futures =
                new LinkedHashMap<>();

        for (ModelService service : services) {
            futures.put(
                    service.getModelName(),
                    CompletableFuture.supplyAsync(
                            () -> service.ask(message),
                            executor
                    )
            );
        }

        Map<String, String> results = new LinkedHashMap<>();

        futures.forEach((model, future) -> {
            try {
                results.put(model, future.get());
            } catch (Exception e) {
                results.put(model, "Error: " + e.getMessage());
            }
        });

        return results;
    }
}
