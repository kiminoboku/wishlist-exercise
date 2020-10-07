package com.example.wishlistexercise.controller;

import com.example.wishlistexercise.model.Priority;
import com.example.wishlistexercise.model.WishlistItem;
import com.example.wishlistexercise.repository.WishlistItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WishlistItemControllerTest {

	@InjectMocks
	WishlistItemController systemUnderTest;

	@Mock
	WishlistItemRepository repository;

	private WishlistItem item = new WishlistItem(1, "Book", "Book about programming", Priority.MUST_HAVE);


	@Test
	public void shouldSaveNewlyCreatedItem() {

		when(repository.save(item)).thenReturn(item);

		systemUnderTest.saveWishlistItem(item);

		verify(repository).save(item);
	}


}