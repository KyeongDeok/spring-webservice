package com.moth.webservice.apis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
//@WebMvcTest(RegistrationApiController.class)
public class RegistrationApiControllerTests {
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	public void register_blackPayload_shouldFailAndReturn400() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post("/api/registrations")).andExpect(MockMvcResultMatchers.status().is(400));
	}
	
}
