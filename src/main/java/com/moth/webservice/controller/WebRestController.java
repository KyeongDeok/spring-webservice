package com.moth.webservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.moth.webservice.domain.PostsRepository;
import com.moth.webservice.domain.PostsSaveRequestDto;
import com.moth.webservice.service.PostsService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class WebRestController {
	
	private PostsRepository postsRepository;
	
	private PostsService postsService;
	
    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }
    
    @PostMapping("/save")
    public Long savePosts(@RequestBody PostsSaveRequestDto dto) {
    	return postsService.save(dto);
    }
}
