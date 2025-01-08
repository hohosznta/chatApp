package com.ll.chatApp.domain.chat.ChatAI.controller;

import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/api/v1/chat")
@RestController
public class ChatAIController {
    private final OpenAiChatModel openAiChatModel;

    public ChatAIController(OpenAiChatModel openAiChatModel) {
        this.openAiChatModel = openAiChatModel;
    }

    @PostMapping("/ai")
    public Map<String, String> chat(@RequestBody String message) {
        Map<String, String> responses =  new HashMap<>();

        String openAiResponse = openAiChatModel.call(message);
        responses.put("response", openAiResponse);
        return responses;
    }

}