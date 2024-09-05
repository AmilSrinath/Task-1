package lk.ijse.gdse.postservice.repo;

import lk.ijse.gdse.postservice.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Amil Srinath
 */
public interface PostServiceDAO extends JpaRepository<Post, String> {

}
