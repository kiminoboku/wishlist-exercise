package com.example.wishlistexercise.controller;

import com.example.wishlistexercise.model.User;
import com.example.wishlistexercise.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CreateUserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    private static String USER_URI = "/user";

    private static String correctUserPayload = "{\"name\":\"FirstUser\"}";

    private static String invalidUserPayload = "{\"name\": }";

    @Test
    public void shouldCreateAndStoreUser() throws Exception {
        mockMvc.perform(post(USER_URI)
		        .contentType(MediaType.APPLICATION_JSON)
		        .content(correctUserPayload))
		        .andExpect(status().isOk());
        List<User> users = userRepository.findAll();
        assertEquals("FirstUser", users.get(0).getName());
    }

    @Test
	public void createNewUserShouldReturnStatus400WhenUserNameIsEmpty() throws Exception{
	    mockMvc.perform(post(USER_URI)
			    .contentType(MediaType.APPLICATION_JSON)
			    .content(invalidUserPayload))
			    .andExpect(status().isBadRequest());
    }

}