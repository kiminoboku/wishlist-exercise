package com.example.wishlistexercise.controller;

import com.example.wishlistexercise.model.User;
import com.example.wishlistexercise.repository.UserRepository;
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
class UserControllerTest {

	@InjectMocks
	UserController systemUnderTest;

	@Mock
	UserRepository userRepository;

	public static User user = new User(1,"FirstUser");

	@BeforeEach
	public void init(){
		when(userRepository.save(user)).thenReturn(user);
	}

	@Test
	public void shouldSaveNewlyCreatedUser() {

		systemUnderTest.createUser(user);

		verify(userRepository).save(user);
	}

	@Test
	public void shouldReturnNewlyCreatedUser(){

		User actual = systemUnderTest.createUser(user);
		User expected = new User(1, "FirstUser");

		assertThat(actual).isEqualToComparingFieldByField(expected);
	}

}