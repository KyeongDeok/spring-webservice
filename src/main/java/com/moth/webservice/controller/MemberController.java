package com.moth.webservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.moth.webservice.domain.MemberRequestDto;
import com.moth.webservice.service.MemberService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class MemberController {
	private MemberService memberService;
	
	//회원가입 페이지
	@GetMapping("/user/signup")
	public String displaySignupPage() {
		return "signup";
	}
	
	//회원가입 처리
	@PostMapping("/user/signup")
	public String signup(@RequestBody MemberRequestDto memberDto) {
		memberService.joinUser(memberDto);
		
		return "main";
	}
	
	//로그인 페이지
	@GetMapping("/user/login")
	public String displayLoginPage() {
		return "login";
	}
	
	//로그인 결과 페이지
	@GetMapping("/user/login/result")
	public String loginResult() {
		return "main";
	}
	
	//로그아웃 결과 페이지
	@GetMapping("user/logout/result")
	public String denied() {
		return "denied";
	}
	
	//내 정보 페이지
	@GetMapping("/user/myinfo")
	public String myinfo() {
		return "myinfo";
	}
	
	//어드민 페이지
	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
}
