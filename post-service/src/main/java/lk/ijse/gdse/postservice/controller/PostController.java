package lk.ijse.gdse.postservice.controller;

import lk.ijse.gdse.postservice.entity.Post;
import lk.ijse.gdse.postservice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Amil Srinath
 */
@RestController
@RequestMapping("/api/v1/post")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/hello")
    public String hello() {
        System.out.println("Done");
        return "Hello";
    }

    @PostMapping("/savePost")
    public ResponseEntity<?> savePost(@RequestBody Post post) {
        postService.savePost(post);
        return ResponseEntity.created(null).build();
    }
}
