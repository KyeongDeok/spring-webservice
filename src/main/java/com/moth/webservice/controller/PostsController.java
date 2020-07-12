package com.moth.webservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.moth.webservice.service.PostsService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class PostsController {
	
	private PostsService postsService;
	
	@GetMapping("/")
	public String main(Model model) {
		model.addAttribute("posts", postsService.fineAllDesc());
		return "main";
	}
}
