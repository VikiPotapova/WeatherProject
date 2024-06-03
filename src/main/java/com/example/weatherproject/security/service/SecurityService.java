/*
package com.example.weatherproject.security.service;

import com.example.weatherproject.exceptionHandler.SameUserInDatabaseException;
import com.example.weatherproject.exceptionHandler.UserNotFoundException;
import com.example.weatherproject.model.Role;
import com.example.weatherproject.model.User;
import com.example.weatherproject.repository.UserRepository;
import com.example.weatherproject.security.model.AuthRequest;
import com.example.weatherproject.security.model.RegistrationDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SecurityService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    public Optional<String> generateToken(AuthRequest authRequest) {
        User user = userRepository.getByLogin(authRequest.getLogin()).orElseThrow(() ->
                new UserNotFoundException("User is not found"));
        if (passwordEncoder.matches(authRequest.getPassword(), user.getPassword())) {
            return Optional.of(jwtUtils.generateJwtToken(authRequest.getLogin()));
        }
        return Optional.empty();
    }

    @Transactional
    public void registration(RegistrationDto registrationDto) {
        if (userRepository.getByLogin(registrationDto.getLogin()).isPresent()) {
            throw new SameUserInDatabaseException("The user already exists");
        }
        User newUser = User.builder()
                .firstName(registrationDto.getFirstName())
                .lastName(registrationDto.getLastName())
                .role(Role.USER)
                .login(registrationDto.getLogin())
                .password(passwordEncoder.encode(registrationDto.getPassword()))
                .build();
        userRepository.save(newUser);
    }
}
*/
