package com.moth.webservice.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.moth.webservice.domain.member.MemberRequestDto;
import com.moth.webservice.service.MemberService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class MemberRestController {
	
	private MemberService memberService;

	//회원가입 처리
	@PostMapping("/user/signup")
	public Long signup(@RequestBody MemberRequestDto dto) throws Exception {
		
		long ret = 0;
		
	    // 가입이 이미 되어 있다면 종료.
		if(memberService.isAlreadyJoin(dto)) {
			return ret;
		}
		
		return memberService.joinUser(dto);
	}
}
