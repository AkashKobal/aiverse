package com.aiverse.aiverse.services;

import org.springframework.stereotype.Service;

@Service
public class QwenService extends BaseOllamaService {
    @Override
    public String getModelName() {
        return "qwen3.5:cloud";
    }

    @Override
    public String ask(String message) {
        return callModel(getModelName(), message);
    }
}
