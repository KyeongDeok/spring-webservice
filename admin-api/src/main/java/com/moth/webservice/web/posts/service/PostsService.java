package com.moth.webservice.web.posts.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moth.webservice.web.posts.dto.PostsMainResponseDTO;
import com.moth.webservice.web.posts.dto.PostsSaveRequestDTO;
import com.moth.webservice.web.posts.repository.PostsRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PostsService {
	
	private PostsRepository postsRepository;
	
	@Transactional
	public Long save(PostsSaveRequestDTO dto) {
		return postsRepository.save(dto.toEntity()).getId();
	}
	
	@Transactional(readOnly = true)
	public List <PostsMainResponseDTO> findAllDesc(){
		return postsRepository.findAllDesc().map(PostsMainResponseDTO::new).collect(Collectors.toList());
	}
	
	//TODO:: Exception 만들자..!!
	@Transactional(readOnly = true)
	public PostsMainResponseDTO findById(Long postId) {
		return new PostsMainResponseDTO(postsRepository.findById(postId).get());
	}
	
	@Transactional
	public Long update (Long postId, PostsSaveRequestDTO dto) {
		
		postsRepository.findById(postId).ifPresent((entity ->{
			entity.updatePostsEntity(dto);
			postsRepository.save(entity);
		}));
		
		return postId;
	}
	
	@Transactional
	public void deleteById (Long postId) {
		postsRepository.deleteById(postId);
	}
}
