package com.example.CURDoperations.repository;

import com.example.CURDoperations.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // Custom query method to find a user by their ID
    // This overrides the default findById method to use Long instead of Integer
    Optional<User> findById(Long id);
}
