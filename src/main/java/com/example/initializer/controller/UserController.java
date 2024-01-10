package com.example.initializer.controller;


import com.example.initializer.exception.GlobalExceptionHandler;
import com.example.initializer.model.User;
import com.example.initializer.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<Object> createUser(@RequestBody @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, Object> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            // Add additional fields
            errors.put("timestamp", LocalDateTime.now().toString());
            return ResponseEntity.badRequest().body(errors);
        }

        try {
            User createdUser = userService.createUser(user);
            return ResponseEntity.ok(createdUser);
        } catch (DataIntegrityViolationException e) {
            Map<String, Object> errors = new HashMap<>();
            errors.put("timesasdasdstamp", LocalDateTime.now().toString());
            errors.put("error", "A user with this information already exists.");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(errors);
        }
    }

//    @PostMapping("/create")
//    public User createUser(@Valid @RequestBody User user) {
//        try {
//            return userService.createUser(user);
//        } catch (Exception e) {
//
//            throw e; // You might want to handle the exception more gracefully based on your requirements
//        }
//    }

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