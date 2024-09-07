package lk.ijse.gdse.userservice.dto;

import lk.ijse.gdse.userservice.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Amil Srinath
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDTO {
    private String userId;
    private String email;
    private String password;
    private Role role;
}
