package com.example.initializer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.initializer.model.User;
import com.example.initializer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired // Injects an instance of UserRepository into this service
    public UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public Optional<User> findUserById(int id) {
        try {
            Optional<User> user = userRepository.findById((long) id);

            if (user.isPresent()) {
                logger.info("{}",  user.get());
            } else {
                logger.info("User not found for ID: {}", id);
            }

            return user;
        } catch (Exception e) {
            logger.error("Error fetching user by ID: {}", id, e);
            throw e; // You might want to handle the exception more gracefully based on your requirements
        }
    }
}