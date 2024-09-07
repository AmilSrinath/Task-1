package lk.ijse.gdse.userservice.controller;

import lk.ijse.gdse.userservice.reqAndresp.response.JwtAuthResponse;
import lk.ijse.gdse.userservice.reqAndresp.secure.SignIn;
import lk.ijse.gdse.userservice.reqAndresp.secure.SignUp;
import lk.ijse.gdse.userservice.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Amil Srinath
 */
@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UserController {
    private final AuthenticationService authenticationService;

    @GetMapping("/health")
    public String health() {
        System.out.println("Done");
        return "User Service is up and running";
    }

    @PostMapping("saveUser")
    public String saveUser() {
        return "Done";
    }

    @PostMapping("/signup")
    public ResponseEntity<JwtAuthResponse> signUp(@RequestBody SignUp signUp) {
        return ResponseEntity.ok(authenticationService.signUp(signUp));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthResponse> signIn(@RequestBody SignIn signInReq) {
        return ResponseEntity.ok(authenticationService.signIn(signInReq));
    }
}
