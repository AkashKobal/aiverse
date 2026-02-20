package com.aiverse.aiverse.controllers;

import com.aiverse.aiverse.dtos.ChatRequest;
import com.aiverse.aiverse.services.ModelRouterService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class MultiModelController {

    private final ModelRouterService router;

    public MultiModelController(ModelRouterService router) {
        this.router = router;
    }

    @PostMapping("/multi-chat")
    public Map<String, String> chat(@RequestBody ChatRequest request) {
        return router.askAll(request.getMessage());
    }
}
