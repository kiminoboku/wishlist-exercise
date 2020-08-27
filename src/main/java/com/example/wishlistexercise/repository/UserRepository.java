package com.example.wishlistexercise.repository;

import com.example.wishlistexercise.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {
}
