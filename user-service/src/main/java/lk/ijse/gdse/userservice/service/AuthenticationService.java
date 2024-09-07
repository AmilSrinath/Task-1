package lk.ijse.gdse.userservice.service;

import lk.ijse.gdse.userservice.reqAndresp.response.JwtAuthResponse;
import lk.ijse.gdse.userservice.reqAndresp.secure.SignIn;
import lk.ijse.gdse.userservice.reqAndresp.secure.SignUp;

/**
 * @author Amil Srinath
 */
public interface AuthenticationService {
    JwtAuthResponse signIn(SignIn signIn);
    JwtAuthResponse signUp(SignUp signUp);
}
