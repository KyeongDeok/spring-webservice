package com.moth.webservice.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SignupTests {
	
	@Autowired
	MockMvc mvc;
	
//	@Test
//	public void 회원가입_폼을_get한후_200을_응답받는다 () throws Exception {
//		mvc.perform(get("/user/signup"))
//			.andDo(print())
//			.andExpect(status().is2xxSuccessful());
//	}
	
	@Test
	public void 회원가입_csrf토큰을_헤더에_담아전송후_200을_응답받는다 () throws Exception {
		
		mvc.perform(post("/user/signup")
				.param("email", "test@test.com")
				.param("password", new BCryptPasswordEncoder().encode("123"))
				.with(csrf()))
		.andDo(print())
		.andExpect(status().is2xxSuccessful());
	}
}
