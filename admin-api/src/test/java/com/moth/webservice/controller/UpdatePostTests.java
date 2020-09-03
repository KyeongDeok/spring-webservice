package com.moth.webservice.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UpdatePostTests {

	@Autowired
	MockMvc mvc;
	
//	@Test
//	public void get_method로_post_가져오기 () throws Exception {
//		
//		mvc.perform(post("/api/posts")
//				.contentType(MediaType.APPLICATION_JSON)
//				.param("email", values)
//				)
//		.andExpect(status().is2xxSuccessful())
//		
//		
//		mvc.perform(
//				post("/api/posts")
//				get("/api/posts/1")
//			.contentType(MediaType.APPLICATION_JSON))
//		.andDo(print())
//		.andExpect(status().is2xxSuccessful());
//	}
	
	@Test
	public void update_post_후_200을_리턴한다 () throws Exception {
		
		mvc.perform(post("/api/posts")
				.contentType(MediaType.APPLICATION_JSON)
				.param("title", "test")
				.param("author", "test")
				.param("content", "est")
				)
		.andExpect(status().is2xxSuccessful());
		
		mvc.perform(put("/api/posts/1")
				.contentType(MediaType.APPLICATION_JSON)
				.param("title", "test")
				.param("author", "test")
				.param("content", "testtest")
				)
		.andExpect(status().is2xxSuccessful());
	}
}
