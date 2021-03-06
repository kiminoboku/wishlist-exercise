package com.example.wishlistexercise.controller;

import com.example.wishlistexercise.model.User;
import com.example.wishlistexercise.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

	@InjectMocks
	UserController systemUnderTest;

	@Mock
	UserRepository userRepository;

	private User user = new User(1, "FirstUser");


	@Test
	public void shouldSaveNewlyCreatedUser() {

		when(userRepository.save(user)).thenReturn(user);

		systemUnderTest.createUser(user);

		verify(userRepository).save(user);
	}


	@Test
	public void shouldReturnNewlyCreatedUser() {

		User expected = user;
		when(userRepository.save(user)).thenReturn(user);

		User actual = systemUnderTest.createUser(user);

		assertThat(actual).isEqualTo(expected);
	}


	@Test
	public void shouldReturnUserWithGivenId() {

		int userId = 1;
		Optional<User> expected = Optional.of(user);
		when(userRepository.findById(userId)).thenReturn(expected);

		Optional<User> actual = systemUnderTest.retrieveUserById(userId);

		assertThat(actual).isEqualTo(expected);
	}

}