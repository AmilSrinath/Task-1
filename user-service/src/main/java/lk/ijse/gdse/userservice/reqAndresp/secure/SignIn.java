package lk.ijse.gdse.userservice.reqAndresp.secure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Amil Srinath
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SignIn {
    private String email;
    private String password;
}
