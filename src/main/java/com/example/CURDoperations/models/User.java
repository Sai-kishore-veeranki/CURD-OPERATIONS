package com.example.CURDoperations.models;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "userdetails")
public class User {

    // Primary key for the User entity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    // Lombok annotation to generate the setter for the 'name' field
    @Setter
    // Lombok annotation to generate the getter for the 'name' field
    @Getter
    String name;

    // Lombok annotation to generate the setter for the 'email' field
    @Setter
    // Lombok annotation to generate the getter for the 'email' field
    @Getter
    String email;
}
