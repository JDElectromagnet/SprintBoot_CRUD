package com.example.initializer.repository;

import com.example.initializer.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // Find user by first name
    Optional<User> findById(Long id);

    User save(User user);

    void deleteById(Long id);
}
