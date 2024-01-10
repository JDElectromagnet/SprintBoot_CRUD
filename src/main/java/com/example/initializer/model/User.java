package com.example.initializer.model;

import jakarta.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "first_name", length = 64, unique = true, nullable = false)
    @NotNull(message = "First name is required.")
    @Size(max = 5, message = "First name must be at most 64 characters")
    private String firstName;

    @Column(name = "last_name", length = 64, unique = true, nullable = false)
    private String lastName;

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
    	this.lastName = lastName;
    }

    //    @Override
//    public String toString() {
//
//        String jsonResponse = "{" +
//                "\"id\":" + id +
//                ",\"firstName\":\"" + firstName + "\"" +
//                ",\"lastName\":\"" + lastName + "\"" +
//                // Add other fields as needed
//                "}";
//
//        return jsonResponse;
////        return "{" +
////                "id=" + id +
////                ", firstName'" + firstName + '\'' +
////                ", lastName='" + lastName + '\'' +
////                // Add other fields as needed
////                '}';
////        return String.format(
////                "{'id':%d, 'firstName':'%s', 'lastName':'%s'}",
////                id, firstName, lastName);
//    }
    // Getters and setters
}