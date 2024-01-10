package com.example.initializer.controller;


import com.example.initializer.dto.UserResponseDTO;
import com.example.initializer.model.User;
import com.example.initializer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public User createUser(@Valid @RequestBody User user) {
        try {
            return userService.createUser(user);
        } catch (Exception e) {

            throw e; // You might want to handle the exception more gracefully based on your requirements
        }
    }

    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) throws Exception {
        return userService.updateUserDetails(id, updatedUser);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
    @GetMapping("/getAll")
    public ResponseEntity<Object> findAll() {
        Optional<User> userOptional = userService.findUserById(1);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return ResponseEntity.ok(user);  // ResponseEntity.ok will automatically serialize the User object to JSON
        } else {
            Map<String, String> error = new HashMap<>();
            error.put("error", "User not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
    }



}