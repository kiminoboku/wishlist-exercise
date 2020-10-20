package com.example.wishlistexercise.repository;

import com.example.wishlistexercise.model.WishlistItem;
import org.springframework.data.jpa.repository.JpaRepository;


public interface WishlistItemRepository extends JpaRepository<WishlistItem, Integer> {
}
