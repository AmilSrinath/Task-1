package lk.ijse.gdse.postservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Amil Srinath
 */
@RestController
@RequestMapping("/api/v1/post")
public class PostController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

}
