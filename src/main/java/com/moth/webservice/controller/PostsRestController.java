package com.moth.webservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.moth.webservice.domain.post.PostsSaveRequestDto;
import com.moth.webservice.service.PostsService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class PostsRestController {
	
	private PostsService postsService;
	
    @GetMapping("/api/hello")
    public String hello() {
        return "HelloWorld";
    }
    
    @PostMapping("/api/posts")
    public Long savePosts(@RequestBody PostsSaveRequestDto dto) {
    	return postsService.save(dto);
    }
}
