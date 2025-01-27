package com.example.CURDoperations.services;


import com.example.CURDoperations.models.User;
import com.example.CURDoperations.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // CREATE: Save a new user
    public User createUser(User user) {

        return userRepository.save(user);
    }

    // READ: Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // READ: Get user by ID
    public User getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null);
    }

    // UPDATE: Update an existing user
    public User updateUser(Long id, User userDetails) {
        User user = getUserById(id);
        if (user != null) {
            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());
            return userRepository.save(user);
        }
        return null;
    }

    // DELETE: Delete a user by ID
    public void deleteUser(Long id) {
        userRepository.deleteById(Math.toIntExact(id));
    }
}
