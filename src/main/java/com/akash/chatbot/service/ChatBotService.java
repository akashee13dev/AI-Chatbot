package com.akash.chatbot.service;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatBotService {

    @Autowired
    OllamaChatModel model;


    public String connectModel(String message) {

        ChatResponse response =  model.call(
                new Prompt(
                        message,
                        OllamaOptions.builder()
                                .model("deepseek-r1:1.5b")
                                .temperature(0.5)
                                .build()
                ));

        return response.getResult().getOutput().getText();

    }
}
