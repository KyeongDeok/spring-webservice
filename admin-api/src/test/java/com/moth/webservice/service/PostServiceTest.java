package com.moth.webservice.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.moth.webservice.web.posts.dto.PostsSaveRequestDTO;
import com.moth.webservice.web.posts.repository.PostsEntity;
import com.moth.webservice.web.posts.repository.PostsRepository;
import com.moth.webservice.web.posts.service.PostsService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostServiceTest {

	@Autowired
	private PostsService postsService;
	
	@Autowired
	private PostsRepository postsRepository;
	
	@After
	public void cleanup() {
		postsRepository.deleteAll();
	}
	
	@Test
	public void DTO데이터가_posts테이블에_저장된다() {
		//given
		PostsSaveRequestDTO dto = PostsSaveRequestDTO.builder().author("moth@gmail.com").content("test content")
				.title("test title").build();
		
		//when
		postsRepository.save(dto.toEntity());
		
		//then
		PostsEntity posts = postsRepository.findAll().get(0);
		assertThat(posts.getAuthor()).isEqualTo("moth@gmail.com");
		assertThat(posts.getContent()).isEqualTo("test content");
		assertThat(posts.getTitle()).isEqualTo("test title");
	}
}
