package com.moth.webservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public List <PostsMainResponseDto> fineAllDesc(){
		return postsRepository.fineAllDesc().map(PostsMainResponseDto::new).collect(Collectors.toList());
	}
}
