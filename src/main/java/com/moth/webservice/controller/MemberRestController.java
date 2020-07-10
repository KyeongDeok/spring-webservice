package com.moth.webservice.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.moth.webservice.domain.MemberRequestDto;
import com.moth.webservice.service.MemberService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class MemberRestController {
	
	private MemberService memberService;

	//회원가입 처리
	@PostMapping("/user/signup")
	public boolean signup(@RequestBody MemberRequestDto dto) {
		
	    // 가입이 안되어 있다면 회원가입 시작.
		if(memberService.isAlreadyJoin(dto)) {
			return true;
		}
		
		memberService.joinUser(dto);
		return false;
	}
}
