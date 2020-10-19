package com.example.wishlistexercise.controller;

import com.example.wishlistexercise.model.Priority;
import com.example.wishlistexercise.model.User;
import com.example.wishlistexercise.model.WishlistItem;
import com.example.wishlistexercise.repository.UserRepository;
import com.example.wishlistexercise.repository.WishlistItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WishlistItemControllerTest {

	@InjectMocks
	WishlistItemController systemUnderTest;

	@Mock
	WishlistItemRepository itemRepository;

	@Mock
	UserRepository userRepository;

	private User user = new User(1, "FirstUser");

	private WishlistItem item = new WishlistItem(1, "Book", "Book about programming", Priority.MUST_HAVE, user);


	@BeforeEach
	public void setup(){
		when(itemRepository.save(item)).thenReturn(item);
		when(userRepository.findById(user.getId())).thenReturn(java.util.Optional.ofNullable(user));
	}


	@Test
	public void shouldSaveNewlyCreatedItem() {

		systemUnderTest.saveWishlistItem(user.getId(), item);

		verify(itemRepository).save(item);
	}

	@Test
	public void shouldReturnNewlyCreatedItem(){

		WishlistItem expected = item;

		WishlistItem actual = systemUnderTest.saveWishlistItem(user.getId(), item);

		assertThat(actual).isEqualTo(expected);
	}

	@Test
	public void shouldFindUserById(){

		systemUnderTest.saveWishlistItem(user.getId(), item);

		verify(userRepository).findById(user.getId());
	}

	@Test
	public void shouldAssignItemToGivenUser(){

		User expected = user;

		User actual = systemUnderTest.saveWishlistItem(user.getId(), item).getUser();

		assertThat(actual).isEqualTo(expected);
	}


}