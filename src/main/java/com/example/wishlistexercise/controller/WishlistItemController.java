package com.example.wishlistexercise.controller;

import com.example.wishlistexercise.model.WishlistItem;
import com.example.wishlistexercise.repository.WishlistItemRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class WishlistItemController {

	@Autowired
	private WishlistItemRepository repository;

	public void saveWishlistItem(WishlistItem item) {
		repository.save(item);
	}
}
