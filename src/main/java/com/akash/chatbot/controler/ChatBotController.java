package com.akash.chatbot.controler;


import com.akash.chatbot.service.ChatBotService;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatBotController {

    @Autowired
    ChatBotService service;


    @GetMapping("/test")
    public String test(){
        return service.connectModel("Generate the names of 5 famous pirates.");
    }


    @GetMapping("api/v1/chat")
    public String chatWithAI(@RequestParam String message){
        return service.connectModel(message);
    }
}
