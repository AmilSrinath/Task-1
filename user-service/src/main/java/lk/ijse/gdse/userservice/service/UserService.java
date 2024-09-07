package lk.ijse.gdse.userservice.service;

import lk.ijse.gdse.userservice.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author Amil Srinath
 */
public interface UserService {
    void save(UserDTO userDTO) throws Exception;
    UserDetailsService userDetailsService();
}
