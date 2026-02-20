package com.aiverse.aiverse.services;

import org.springframework.stereotype.Service;

@Service
public class MinistralService extends BaseOllamaService {
    @Override
    public String getModelName() {
        return "ministral-3:8b-cloud";
    }

    @Override
    public String ask(String message) {
        return callModel(getModelName(), message);
    }
}
