package lk.ijse.gdse.userservice.controller;

import org.springframework.web.bind.annotation.*;

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

    @PostMapping("saveUser")
    public String saveUser() {
        return "Done";
    }
}
