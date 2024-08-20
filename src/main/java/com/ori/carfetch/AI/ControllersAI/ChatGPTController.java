package com.ori.carfetch.AI.ControllersAI;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/")
public class ChatGPTController {

//    private final OpenAIService openAIService;
    private final ChatClient chatClient;

    public ChatGPTController(ChatClient.Builder chatClientBuilder) {
//        this.openAIService = openAIService;
        this.chatClient = chatClientBuilder.build();
    }

    @GetMapping("/ai")
    String generation(String userInput) {
        return this.chatClient.prompt()
                .user(userInput)
                .call()
                .content();
    }


}
