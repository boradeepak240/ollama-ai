package com.gladius.spring.ollama.ollama.services;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.gladius.spring.ollama.entity.Tut;


@Service
public class ChatServiceImpl implements ChatService {

    private ChatClient chatClient;

     @Value("classpath:/prompts/user-message.st")
    private String userMessage;

    @Value("classpath:/prompts/system-message.st")
    private String systemMessage;

    ChatServiceImpl(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @Override
    public Tut chat(String query) {
        String queryst = "As an expert in Coding and Programming, always write program in Java. Now reply for this question: {query}";
        var tutorial = chatClient
                .prompt()
                .user(u-> u.text(queryst).param("query", query))
                .call()
                .entity(Tut.class);
        
        return tutorial;
    }

    @Override
    public String chatTemplate(String query) {
        return this.chatClient
        .prompt()
        .system(system->
            system.text(this.systemMessage))
        .user(user->
            user.text(this.userMessage).param("concept", query))
        .call()
        .content();
    }



    // @Override
    // public Tut chat(String query) {
    //     String prompt =query;

    //     String queryst = "As an expert in Coding and Programming, always write program in Java. Now reply for this question: {query}";
        
        
    //     return chatClient
    //             .prompt(new Prompt(prompt))
    //             .call()
    //             .entity(Tut.class);
    // }

    // @Override
    // public Tut chat(String query) {
    //     String prompt ="Tell me about Andrej Karpathy";
    //     Prompt prompt1 = new Prompt(query);
    //     Tut content = chatClient
    //             .prompt(prompt1)
    //             .call()
    //             .entity(Tut.class);
    //             // .chatResponse()
    //             // .getResult()
    //             // .getOutput()
    //             // .getText();

    //             System.out.println(content);
    //     return content;
    // }
    
}
