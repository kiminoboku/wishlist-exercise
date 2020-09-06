package com.example.wishlistexercise.controller;

import com.example.wishlistexercise.model.User;
import com.example.wishlistexercise.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RetrieveUserUnitTest {

	@InjectMocks
	UserController systemUnderTest;

	@Mock
	UserRepository userRepository;

	public static Optional<User> user = Optional.of(new User(1, "FirstUser"));

	@BeforeEach
	public void init(){
		when(userRepository.findById(1)).thenReturn(user);
	}

	@Test
	public void shouldReturnUserWithGivenId() {

		Optional<User> actual = systemUnderTest.retrieveUserById(1);

		assertEquals(1, actual.get().getId());
		assertEquals("FirstUser", actual.get().getName());


	}



}