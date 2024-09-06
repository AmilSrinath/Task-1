package lk.ijse.gdse.aiservice.controller;

import lk.ijse.gdse.aiservice.dto.RequestDTO;
import lk.ijse.gdse.aiservice.model.ChatCompletionRequest;
import lk.ijse.gdse.aiservice.model.ChatCompletionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author Amil Srinath
 */
@RestController
@RequestMapping("api/v1/ai")
public class AiController {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/health")
    public String health() {
        return "OK";
    }

    @PostMapping("/chat")
    public String getOpenaiResponse(@RequestBody RequestDTO requestDTO) {

        String command = "";
        switch (requestDTO.getIndex()){
            case 1:
                command = "Rewrite this paragraph: " + requestDTO.getMessage();
                break;
            case 2:
                command = "Summarize this paragraph: " + requestDTO.getMessage();
                break;
            case 3:
                command = "Spelling correction: " + requestDTO.getMessage();
                break;
        }

        ChatCompletionRequest chatCompletionRequest = new ChatCompletionRequest("gpt-3.5-turbo", command);
        ChatCompletionResponse response = restTemplate.postForObject("https://api.openai.com/v1/chat/completions", chatCompletionRequest, ChatCompletionResponse.class);
        return response.getChoices().get(0).getMessage().getContent();
    }
}
