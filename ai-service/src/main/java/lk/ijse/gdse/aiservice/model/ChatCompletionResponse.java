package lk.ijse.gdse.aiservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.util.List;

/**
 * @author Amil Srinath
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChatCompletionResponse {
    private List<Choice> choices;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Choice {
        private int index;
        private ChatMessage message;
    }
}
