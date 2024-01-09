package com.example.initializer.controller;


import com.example.initializer.model.User;
import com.example.initializer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
//
//    @GetMapping("/getAll")
//    public ResponseEntity<Object> findAll() {
//        Optional<User> userOptional = userService.findUserById(1);
//
//        if (userOptional.isPresent()) {
//            User user = userOptional.get();
//            return new ResponseEntity<>(user, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
//        }
//    }


    @GetMapping("/getAll")
    public ResponseEntity<Object> findAll() {
        Optional<User> userOptional = userService.findUserById(1);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            Map<String, String> error = new HashMap<>();
            error.put("error", "User not found");
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }
    }

//
//    @GetMapping("/{userId}")
//    public Optional<User> getUserById(@PathVariable Long userId) {
//        return userService.getUserById(userId);
//    }
//
//    @PostMapping
//    public User createUser(@RequestBody User user) {
//        return userService.createUser(user);
//    }
//
//    @PutMapping("/{userId}")
//    public User updateUser(@PathVariable Long userId, @RequestBody User userDetails) {
//        return userService.updateUser(userId, userDetails);
//    }
//
//    @DeleteMapping("/{userId}")
//    public void deleteUser(@PathVariable Long userId) {
//        userService.deleteUser(userId);
//    }
}