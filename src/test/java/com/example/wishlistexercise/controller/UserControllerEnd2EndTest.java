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
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerEnd2EndTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    private static String USER_URI = "/user";

    private static String USER_ID_URI = "/user/1";

    private static String correctUserPayload = "{\"name\":\"SecondUser\"}";

    private static String invalidUserPayload = "{\"name\": }";

    @Test
    public void shouldCreateAndStoreUser() throws Exception {
        mockMvc.perform(post(USER_URI)
		        .contentType(MediaType.APPLICATION_JSON)
		        .content(correctUserPayload))
		        .andExpect(status().isOk());
        List<User> users = userRepository.findAll();
	    assertEquals(2, users.get(1).getId());
        assertEquals("SecondUser", users.get(1).getName());
    }

    @Test
	public void createNewUserShouldReturnStatus400WhenUserNameIsEmpty() throws Exception{
	    mockMvc.perform(post(USER_URI)
			    .contentType(MediaType.APPLICATION_JSON)
			    .content(invalidUserPayload))
			    .andExpect(status().isBadRequest());
    }

	@Test
	public void shouldFetchUserWithGivenId() throws Exception {
		mockMvc.perform(get(USER_ID_URI))
				.andExpect(status().isOk());
		Optional<User> user = userRepository.findById(1);
		assertEquals(1, user.get().getId());
		assertEquals("FirstUser", user.get().getName());
	}

}