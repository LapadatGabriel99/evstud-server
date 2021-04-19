package com.facultate.evstud.service;

import com.facultate.evstud.model.User;
import com.facultate.evstud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {

        return userRepository.save(user);
    }

    public List<User> getAllUsers() {

        return userRepository.findAll(Sort.by(Sort.Direction.ASC, "username"));
    }

    public List<User> getAllUsersByRole(String roleName) {

        return userRepository.findAllByRole(roleName);
    }

    public User updateUser(User user) {

        return userRepository.save(user);
    }

    public void deleteUser(Long id) {

        var user = userRepository.findById(id);

        userRepository.delete(user.orElseThrow(() -> new IllegalStateException("User not found")));
    }
}
