package com.gladius.spring.ollama.ollama.services;

import com.gladius.spring.ollama.entity.Tut;

public interface ChatService {
    Tut chat(String query);
    String chatTemplate(String query);
}
