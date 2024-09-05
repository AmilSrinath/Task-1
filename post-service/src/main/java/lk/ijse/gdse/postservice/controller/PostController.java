package lk.ijse.gdse.postservice.controller;

import lk.ijse.gdse.postservice.entity.Post;
import lk.ijse.gdse.postservice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

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

    @GetMapping("/getAll")
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> posts = postService.getAllPosts();
        return ResponseEntity.ok(posts);
    }

    @PostMapping(value = "/savePost", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> savePost(
            @RequestPart("title") String title,
            @RequestPart("description") String description,
            @RequestPart("image") MultipartFile image) throws IOException {
        byte[] imageBytes = image.getBytes();
        postService.savePost(new Post(title, description, imageBytes));
        return ResponseEntity.created(null).build();
    }

    @DeleteMapping("/deletePost/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable int id) {
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/updatePost/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Post> updatePost(
            @PathVariable int id,
            @RequestPart("title") String title,
            @RequestPart("description") String description,
            @RequestPart("image") MultipartFile image) throws IOException {
        byte[] imageBytes = image.getBytes();
        Post updatedPost = new Post(title, description, imageBytes);
        Post post = postService.updatePost(id, updatedPost);
        return ResponseEntity.ok(null);
    }
}
