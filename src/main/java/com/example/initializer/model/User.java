package com.example.initializer.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", length = 64, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 64, nullable = false)
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