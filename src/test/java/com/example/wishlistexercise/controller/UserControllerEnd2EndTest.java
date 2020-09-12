package com.example.wishlistexercise.controller;

import com.example.wishlistexercise.model.User;
import com.example.wishlistexercise.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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

	@Autowired
	private ObjectMapper objectMapper;

    private static String USER_URI = "/user";

    private static String USER_ID_URI = "/user/1";

    private static String correctUserPayload = "{\"name\":\"SecondUser\"}";

    private static String invalidUserPayload = "{\"name\": }";

    @Test
    public void shouldCreateAndStoreUser() throws Exception {

    	MvcResult result = mockMvc.perform(post(USER_URI)
		        .contentType(MediaType.APPLICATION_JSON)
		        .content(correctUserPayload))
		        .andReturn();
	    String contentAsString = result.getResponse().getContentAsString();
	    User actual = objectMapper.readValue(contentAsString, User.class);

        assertNotNull(actual.getId());
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

		MvcResult result = mockMvc.perform(get(USER_ID_URI)).andReturn();
		String contentAsString = result.getResponse().getContentAsString();

		User actual = objectMapper.readValue(contentAsString, User.class);
		User expected = new User(1, "FirstUser");

		assertThat(actual).isEqualToComparingFieldByField(expected);
	}

}