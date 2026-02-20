package com.aiverse.aiverse.services;

import org.springframework.stereotype.Service;

@Service
public class GptOssService extends BaseOllamaService {

    @Override
    public String getModelName() {
        return "gpt-oss:120b-cloud";
    }

    @Override
    public String ask(String message) {
        return callModel(getModelName(), message);
    }
}
