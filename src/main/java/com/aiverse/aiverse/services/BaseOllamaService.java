package com.aiverse.aiverse.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public abstract class BaseOllamaService implements ModelService {

    private static final String OLLAMA_URL = "http://localhost:11434/api/chat";

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    protected String callModel(String modelName, String message) {
        Map<String, Object> body = Map.of(
                "model", modelName,
                "messages", new Object[]{
                        Map.of("role", "user", "content", message)
                },
                "stream", false
        );

        try {
            String response = restTemplate.postForObject(
                    OLLAMA_URL,
                    body,
                    String.class
            );

            JsonNode root = objectMapper.readTree(response);
            return root.path("message").path("content").asText();

        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}
