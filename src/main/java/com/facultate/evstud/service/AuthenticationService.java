package com.facultate.evstud.service;

import com.facultate.evstud.model.User;
import com.facultate.evstud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> authenticateUser(User user) {

        var dbUser = userRepository.findByUsername(user.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!dbUser.getPassword().equals(user.getPassword())) {

            throw new IllegalStateException("Invalid credentials");
        }

        return Optional.of(dbUser);
    }
}
