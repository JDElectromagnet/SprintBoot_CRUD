package com.example.initializer.dto;

public class UserResponseDTO {
    private Long id;
    private String firstName;
    private String lastName;

    public UserResponseDTO() {
    }

    public UserResponseDTO(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters and setters...

    // You can also add other methods if needed
}