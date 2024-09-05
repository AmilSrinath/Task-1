package lk.ijse.gdse.postservice.service;

import lk.ijse.gdse.postservice.entity.Post;
import org.springframework.http.ResponseEntity;

/**
 * @author Amil Srinath
 */
public interface PostService {
    void savePost(Post post);
    void deletePost(int id);
    Post updatePost(int id, Post updatedPost);
}
