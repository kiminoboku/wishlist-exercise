package com.example.wishlistexercise.controller;

import com.example.wishlistexercise.model.WishlistItem;
import com.example.wishlistexercise.repository.UserRepository;
import com.example.wishlistexercise.repository.WishlistItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class WishlistItemController {

	@Autowired
	private WishlistItemRepository itemRepository;

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/item/{userId}")
	public WishlistItem saveWishlistItem(@PathVariable(value = "userId") Integer userId,
	                                     @RequestBody WishlistItem item) {

		return userRepository.findById(userId).map(user -> {
			item.setUser(user);
			return itemRepository.save(item);
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
	}

}
