package com.ChagptApp.chagpt.controller;

import com.ChagptApp.chagpt.dto.ChatGPTRequest;
import com.ChagptApp.chagpt.dto.ChatGptResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/bot")
public class CustomBotController {

    @Value("${openai.model}")
    private String model;

    @Value(("${openai.api.url}"))
    private String apiURL;

    @Autowired
    private RestTemplate template;

    @GetMapping("/chat")
    public ChatGptResponse chat(@RequestParam("prompt") String prompt){
        ChatGPTRequest request=new ChatGPTRequest(model, prompt);
        ChatGptResponse chatGptResponse = template.postForObject(apiURL, request, ChatGptResponse.class);
        // if you want a short string response
        //return chatGptResponse.getChoices().get(0).getMessage().getContent();
        return chatGptResponse ;
    }
}
