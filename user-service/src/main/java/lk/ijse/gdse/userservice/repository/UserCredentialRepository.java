package lk.ijse.gdse.userservice.repository;

import lk.ijse.gdse.userservice.entity.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Amil Srinath
 */
public interface UserCredentialRepository extends JpaRepository<UserCredential,Integer> {
    Optional<UserCredential> findByName(String username);
}
