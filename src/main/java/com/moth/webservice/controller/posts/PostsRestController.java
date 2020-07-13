package com.moth.webservice.controller.posts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	
    @PostMapping("/api/posts")
    public Long savePosts(@RequestBody PostsSaveRequestDto dto, HttpServletRequest request) {
    	
    	HttpSession session = request.getSession();
    	String author = (String) session.getAttribute("user");
    	
    	dto.setAuthor(author);
    	return postsService.save(dto);
    }
}
