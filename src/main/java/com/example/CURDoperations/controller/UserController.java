package com.example.CURDoperations.controller;

import com.example.CURDoperations.models.User;
import com.example.CURDoperations.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    // CREATE: Endpoint to create a new user
    // This method handles HTTP POST requests to /user/createuser and expects a User object in the request body
    @PostMapping("/createuser")
    public User createUsers(@RequestBody User user) {
        return userService.createUser(user);
    }

    // READ: Endpoint to get all users
    // This method handles HTTP GET requests to /user/getallusers and returns a list of all users
    @GetMapping("/getallusers")
    public List<User> getAllUser() {
        return userService.getAllUsers();
    }

    // READ: Endpoint to get a user by ID
    // This method handles HTTP GET requests to /user/getuser/{id} and returns the user with the specified ID
    @GetMapping("/getuser/{id}")
    public User getUserByIds(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // UPDATE: Endpoint to update an existing user
    // This method handles HTTP PUT requests to /user/update/{id} and expects the updated User details in the request body
    // It first retrieves the user by ID, then updates the user's name and email, and saves the updated user
    @PutMapping("/update/{id}")
    public User updateUsers(@PathVariable Long id, @RequestBody User userDetails) {
        User user = userService.getUserById(id);
        if (user != null) {
            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());
            return userService.createUser(user);
        }
        return null;
    }

    // DELETE: Endpoint to delete a user by ID
    // This method handles HTTP DELETE requests to /user/delete/{id} and deletes the user with the specified ID
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
