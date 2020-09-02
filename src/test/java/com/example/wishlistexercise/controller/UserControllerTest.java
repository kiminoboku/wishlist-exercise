package com.example.wishlistexercise.controller;

import com.example.wishlistexercise.model.User;
import com.example.wishlistexercise.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

	@InjectMocks
	UserController systemUnderTest;

	@Mock
	UserRepository userRepository;
	

	@Test
	public void shouldSaveNewlyCreatedUser() {

		User user = new User("FirstUser");
		when(userRepository.save(user)).thenReturn(user);

		systemUnderTest.createUser(user);

		verify(userRepository).save(user);
	}

}