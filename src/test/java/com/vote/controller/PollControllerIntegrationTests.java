package com.vote.controller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.vote.service.PollService;

//@SpringBootTest
@WebMvcTest
@AutoConfigureMockMvc
@ContextConfiguration(classes= {TestSecurityConfig.class})
public class PollControllerIntegrationTests {
	

	
	@MockBean
	private PollService pollService;
	
	@Autowired
	PollController voteController;
	
	@Autowired
	private  MockMvc mockMvc;
	
	
	
	@Test
	public void whenPostRequestToVoteAndInValidPoll_thenCorrectResponse() throws Exception {
//		MediaType jsonBody = new MediaType(MediaType.APPLICATION_JSON);
//		String jsonPayload = "{\"question\":\"Who will win?\",\"picks\":[{\"pickOption\":\"Team A\",\"count\":0}]}";
		String jsonPayload = "{\"question\":\"\",\"picks\":[{\"pickOption\":\"Team A\",\"count\":0}]}";
		mockMvc.perform(MockMvcRequestBuilders.post("/polls").content(jsonPayload).contentType(MediaType.APPLICATION_JSON).header("X-API-KEY", "wills-world")).andExpect(MockMvcResultMatchers.status().isBadRequest());
		
	}
	
	

}
