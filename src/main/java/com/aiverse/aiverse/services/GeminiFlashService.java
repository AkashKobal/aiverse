package com.aiverse.aiverse.services;

import org.springframework.stereotype.Service;

@Service
public class GeminiFlashService extends BaseOllamaService {
    @Override
    public String getModelName() {
        return "gemini-3-flash-preview:cloud";
    }

    @Override
    public String ask(String message) {
        return callModel(getModelName(), message);
    }
}
