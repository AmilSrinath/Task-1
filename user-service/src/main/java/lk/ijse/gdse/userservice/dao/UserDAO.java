package lk.ijse.gdse.userservice.dao;

import lk.ijse.gdse.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Amil Srinath
 */
public interface UserDAO extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email);
}
