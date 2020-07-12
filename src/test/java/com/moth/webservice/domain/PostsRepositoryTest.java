package com.moth.webservice.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.After;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.moth.webservice.domain.post.PostsEntity;
import com.moth.webservice.domain.post.PostsRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

	@Autowired
	PostsRepository postsRepository;
	
	@After
	public void cleanup() {
		postsRepository.deleteAll();
	}
	
	@Test
	public void 게시글저장_불러오기() {
		postsRepository.save(PostsEntity.builder().author("moth@gmail.com").title("test title").content("test contents").build());
		
		List<PostsEntity> postsList = postsRepository.findAll();
		
		PostsEntity posts = postsList.get(0);
		
		assertThat(posts.getTitle(), is("test title"));
        assertThat(posts.getContent(), is("test contents"));
	}
	
	@Test
	public void BaseTimeEntity_등록() {
		LocalDateTime now = LocalDateTime.now();
		postsRepository.save(PostsEntity.builder().title("test title").author("moth@gmail.com").content("test content").build());
		
		List <PostsEntity> postsList = postsRepository.findAll();
		
		PostsEntity posts = postsList.get(0);
		
		assertTrue(posts.getCreatedDate().isAfter(now));
		assertTrue(posts.getModifiedDate().isAfter(now));
	}
}
