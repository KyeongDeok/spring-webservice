package com.moth.webservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.moth.webservice.domain.PostRepository;
import com.moth.webservice.domain.PostsSaveRequestDto;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class WebRestController {
	
	private PostRepository postsRepository;
	
    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }
    
    @PostMapping("/save")
    public void savePosts(@RequestBody PostsSaveRequestDto dto) {
    	postsRepository.save(dto.toEntity());
    }
}
