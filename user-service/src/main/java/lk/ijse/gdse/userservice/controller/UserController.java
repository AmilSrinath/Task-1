package lk.ijse.gdse.userservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Amil Srinath
 */
@RestController
@RequestMapping("api/v1/user")
public class UserController {
    @GetMapping("/health")
    public String health() {
        System.out.println("Done");
        return "User Service is up and running";
    }
}
