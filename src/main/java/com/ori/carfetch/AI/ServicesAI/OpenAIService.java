package com.ori.carfetch.AI.ServicesAI;

import org.springframework.stereotype.Service;

@Service
public class OpenAIService {
//
//    @Value("${openai.api.key}")
//    private String apiKey;
//
//    private final RestTemplate restTemplate = new RestTemplate();
//
//    public String getChatGPTResponse(String prompt) {
//        String url = "https://api.openai.com/v1/completions";
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Authorization", "Bearer " + apiKey);
//        headers.set("Content-Type", "application/json");
//
//        String requestBody = "{\"model\": \"text-davinci-003\", \"prompt\": \"" + prompt + "\", \"max_tokens\": 100}";
//        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
//
//        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
//
//        return response.getBody();
//    }
}
