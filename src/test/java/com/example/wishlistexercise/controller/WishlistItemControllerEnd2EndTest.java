package com.example.wishlistexercise.controller;

import com.example.wishlistexercise.model.WishlistItem;
import com.example.wishlistexercise.repository.UserRepository;
import com.example.wishlistexercise.repository.WishlistItemRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class WishlistItemControllerEnd2EndTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private WishlistItemRepository itemRepository;

	@Autowired
	private ObjectMapper objectMapper;

	private static String ITEM_URI = "/item/1";

	private static String USER_NOT_FOUND_URI = "/item/5";

	private static String correctItemPayload = "{\"name\":\"Book\", " +
			"\"comments\": \"Book about programming\", " +
			"\"priority\": \"MUST_HAVE\"}";

	private static String incorrectItemPayload = "{\"name\":\"Book\", " +
			"\"comments\": \"Book about programming\", " +
			"\"priority\": \"WOULD_LIKE_TO_HAVE\"}";

	@Test
	public void shouldCreateAndStoreWishlistItem() throws Exception{

		MvcResult result = mockMvc.perform(post(ITEM_URI)
				.contentType(MediaType.APPLICATION_JSON)
				.content(correctItemPayload))
				.andReturn();

		String contentAsString = result.getResponse().getContentAsString();
		WishlistItem actual = objectMapper.readValue(contentAsString, WishlistItem.class);
		assertNotNull(actual.getId());
	}

	@Test
	public void saveWishlistItemShouldReturnStatus400WhenItemPriorityIsIncorrect() throws Exception{

		mockMvc.perform(post(ITEM_URI)
				.contentType(MediaType.APPLICATION_JSON)
				.content(incorrectItemPayload))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void saveWishlistItemShouldReturnStatus404WhenUserNotFound() throws Exception{

		mockMvc.perform(post(USER_NOT_FOUND_URI)
				.contentType(MediaType.APPLICATION_JSON)
				.content(correctItemPayload))
				.andExpect(status().isNotFound());
	}

}
