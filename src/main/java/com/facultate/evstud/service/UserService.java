package com.facultate.evstud.service;

import com.facultate.evstud.model.User;
import com.facultate.evstud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationService authenticationService;

    public User login(User user) {

        return authenticationService.authenticateUser(user)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
