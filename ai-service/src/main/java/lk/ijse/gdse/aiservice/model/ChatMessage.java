package lk.ijse.gdse.aiservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Amil Srinath
 */
@AllArgsConstructor
@Data
public class ChatMessage {
    private String role;
    private String content;
}
