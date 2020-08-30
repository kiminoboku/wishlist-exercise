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

    private String uri = "/user";

    @Test
    public void creatingNewUserEnd2EndTest() throws Exception {
        mockMvc.perform(post(uri)
		        .contentType(MediaType.APPLICATION_JSON)
		        .content("{ \"name\":\"FirstUser\"}"))
		        .andExpect(status().isOk());
        List<User> users = userRepository.findAll();
        assertEquals("FirstUser", users.get(0).getName());
    }

    @Test
	public void shouldReturnStatus400WhenUserNameIsEmpty() throws Exception{
	    mockMvc.perform(post(uri)
			    .contentType(MediaType.APPLICATION_JSON)
			    .content("{\"name\": }"))
			    .andExpect(status().isBadRequest());
    }

}