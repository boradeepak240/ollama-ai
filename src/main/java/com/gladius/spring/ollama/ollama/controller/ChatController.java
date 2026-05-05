package com.gladius.spring.ollama.ollama.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gladius.spring.ollama.ollama.services.ChatService;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    // ChatClient chatClient;

    // public ChatController(ChatClient.Builder builder) {
    //     this.chatClient = builder.build();
    // }

    ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/chat")
    public ResponseEntity<String> chat(
        @RequestParam(value="q") String q
    ) {
        // String response = chatClient.prompt(q).call().content();
        return ResponseEntity.ok(chatService.chatTemplate(q));
    }
    
}
