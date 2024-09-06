package lk.ijse.gdse.aiservice.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Amil Srinath
 */
@Data
public class ChatCompletionRequest {
    private String model;
    private List<ChatMessage> messages;

    public ChatCompletionRequest(String model, String prompt) {
        this.model = model;
        this.messages = new ArrayList<ChatMessage>();
        this.messages.add(new ChatMessage("user", prompt));
    }
}
