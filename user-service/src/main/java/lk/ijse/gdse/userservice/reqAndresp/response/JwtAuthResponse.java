package lk.ijse.gdse.userservice.reqAndresp.response;

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
public class JwtAuthResponse {
    private String token;
    private Role role;
}
