package com.aiverse.aiverse.services;

import org.springframework.stereotype.Service;

@Service
public class MinimaxService extends BaseOllamaService {

    @Override
    public String getModelName() {
        return "minimax-m2.5:cloud";
    }

    @Override
    public String ask(String message) {
        return callModel(getModelName(), message);
    }
}
