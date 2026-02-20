package com.aiverse.aiverse.services;

import org.springframework.stereotype.Service;

@Service
public class KimiService extends BaseOllamaService {
    @Override
    public String getModelName() {
        return "kimi-k2.5:cloud";
    }

    @Override
    public String ask(String message) {
        return callModel(getModelName(), message);
    }
}
