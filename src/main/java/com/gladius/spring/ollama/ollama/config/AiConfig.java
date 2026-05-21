package com.gladius.spring.ollama.ollama.config;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SafeGuardAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiConfig {
    private Logger logger = LoggerFactory.getLogger(AiConfig.class); 
    
    @Bean
    public ChatClient chatClient(ChatClient.Builder builder, ChatMemory chatMemory) {
        this.logger.info("ChatMemoryInplementation class: "+chatMemory.getClass().getName());
        MessageChatMemoryAdvisor messageChatMemoryAdvisor = MessageChatMemoryAdvisor.builder(chatMemory).build();

        return builder
        .defaultAdvisors(messageChatMemoryAdvisor, new SimpleLoggerAdvisor(), new SafeGuardAdvisor(List.of("game")))
        .defaultSystem("You are a helpful coding assistant. You are an expert in coding.")
        .defaultOptions(ChatOptions.builder()
            .model("deepseek-r1:1.5b")
            .temperature(0.3)
            .maxTokens(2000))
        .build();
    }
}
