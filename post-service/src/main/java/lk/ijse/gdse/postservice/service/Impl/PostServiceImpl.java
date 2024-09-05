package lk.ijse.gdse.postservice.service.Impl;

import lk.ijse.gdse.postservice.entity.Post;
import lk.ijse.gdse.postservice.repo.PostServiceDAO;
import lk.ijse.gdse.postservice.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
}
