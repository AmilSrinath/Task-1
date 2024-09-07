package lk.ijse.gdse.userservice.service.impl;

import lk.ijse.gdse.userservice.conversion.Mapping;
import lk.ijse.gdse.userservice.dao.UserDAO;
import lk.ijse.gdse.userservice.dto.UserDTO;
import lk.ijse.gdse.userservice.entity.Role;
import lk.ijse.gdse.userservice.entity.User;
import lk.ijse.gdse.userservice.reqAndresp.response.JwtAuthResponse;
import lk.ijse.gdse.userservice.reqAndresp.secure.SignIn;
import lk.ijse.gdse.userservice.reqAndresp.secure.SignUp;
import lk.ijse.gdse.userservice.service.AuthenticationService;
import lk.ijse.gdse.userservice.service.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author Amil Srinath
 */
@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private  final UserDAO userDAO;
    private final Mapping mapping;

    @Override
    public JwtAuthResponse signIn(SignIn signIn) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signIn.getEmail(), signIn.getPassword()));
        var userByEmail = userDAO.findByEmail(signIn.getEmail()).orElseThrow(() -> new UsernameNotFoundException("Email not found"));
        String token = jwtService.generateToken(userByEmail);
        Role role = userByEmail.getRole();
        return JwtAuthResponse.builder()
                .token(token)
                .role(role)
                .build();
    }

    @Override
    public JwtAuthResponse signUp(SignUp signUp) {
        UserDTO build = UserDTO.builder()
                .userId(UUID.randomUUID().toString())
                .email(signUp.getEmail())
                .password(passwordEncoder.encode(signUp.getPassword()))
                .role(Role.valueOf(signUp.getRole()))
                .build();

        User user = userDAO.save(mapping.toUser(build));
        String generateToken = jwtService.generateToken(user);
        return JwtAuthResponse.builder().token(generateToken).build();
    }
}
