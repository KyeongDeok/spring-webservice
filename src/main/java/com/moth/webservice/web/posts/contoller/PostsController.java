package com.moth.webservice.web.posts.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.moth.webservice.web.posts.dto.PostsSaveRequestDTO;
import com.moth.webservice.web.posts.service.PostsService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class PostsController {
	
	private PostsService postsService;
	
	@GetMapping("/")
	public String listPosts(Model model) {
		model.addAttribute("posts", postsService.findAllDesc());
		return "main";
	}
	
	@GetMapping("/api/posts/{postId}")
	public String showPost (@PathVariable Long postId, Model model) {
		
		model.addAttribute("post", postsService.findById(postId));
		return "postInfo";
	}
	
	@GetMapping("/api/updatePost/{postId}")
	public String showUpdatePost(@PathVariable Long postId, Model model) {
		
		model.addAttribute("post", postsService.findById(postId));
		return "updatePost";
	}
    
	@PutMapping("/api/posts/{postId}")
	public String updatePost(PostsSaveRequestDTO dto, @PathVariable Long postId) {
		
    	postsService.update(postId, dto);
		return "redirect:/";
	}	
}
