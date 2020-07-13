package com.moth.webservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moth.webservice.domain.post.PostsEntity;
import com.moth.webservice.domain.post.PostsMainResponseDto;
import com.moth.webservice.domain.post.PostsRepository;
import com.moth.webservice.domain.post.PostsSaveRequestDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PostsService {
	
	private PostsRepository postsRepository;
	
	@Transactional
	public Long save(PostsSaveRequestDto dto) {
		return postsRepository.save(dto.toEntity()).getId();
	}
	
	@Transactional(readOnly = true)
	public List <PostsMainResponseDto> findAllDesc(){
		return postsRepository.findAllDesc().map(PostsMainResponseDto::new).collect(Collectors.toList());
	}
	
	//TODO:: Exception 만들자..!!
	@Transactional(readOnly = true)
	public PostsMainResponseDto findById(Long postId) {
		System.out.println(postId);
		return new PostsMainResponseDto(postsRepository.findById(postId).get());
	}
	
	@Transactional
	public Long update (Long postId, PostsSaveRequestDto dto) {
		PostsEntity entity =  postsRepository.findById(postId).get();
		entity.updatePostsEntity(dto);
		
		return postsRepository.save(entity).getId();
	}
}
