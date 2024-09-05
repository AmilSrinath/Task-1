package lk.ijse.gdse.postservice.service.Impl;

import lk.ijse.gdse.postservice.entity.Post;
import lk.ijse.gdse.postservice.repo.PostServiceDAO;
import lk.ijse.gdse.postservice.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Amil Srinath
 */
@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    @Autowired
    private PostServiceDAO postServiceDAO;

    @Override
    public void savePost(Post post) {
        postServiceDAO.save(post);
    }

    @Override
    public void deletePost(int id) {
        postServiceDAO.deleteById(String.valueOf(id));
    }

    @Override
    public Post updatePost(int id, Post updatedPost) {
        return postServiceDAO.findById(String.valueOf(id)).map(post -> {
            post.setTitle(updatedPost.getTitle());
            post.setDescription(updatedPost.getDescription());
            post.setImage(updatedPost.getImage());
            return postServiceDAO.save(post);
        }).orElseThrow(() -> new RuntimeException("Post not found with id " + id));
    }

    @Override
    public List<Post> getAllPosts() {
        return postServiceDAO.findAll();
    }
}
