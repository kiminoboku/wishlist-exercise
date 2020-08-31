package com.example.wishlistexercise.controller;

import com.example.wishlistexercise.model.User;
import com.example.wishlistexercise.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class UserControllerTest {

	@InjectMocks
	UserController userController;

	@Mock
	UserRepository userRepository = mock(UserRepository.class);

	private static User user = new User("FirstUser");

	@Test
	public void saveUserMethodIsInvokedWhenCreatingUser() {
		when(userRepository.save(user)).thenReturn(user);
		userController.createUser(user);
		verify(userRepository, times(1)).save(user);
	}

}