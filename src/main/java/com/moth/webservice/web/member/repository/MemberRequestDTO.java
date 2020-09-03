package com.moth.webservice.web.member.repository;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberRequestDTO {

	private String email;
	private String password;
	
	public MemberEntity toEntity() {
		return MemberEntity.builder()
				.email(email)
				.password(password)
				.build();
	}
	
	@Builder
	public MemberRequestDTO(String email, String password) {
		this.email = email;
		this.password = password;
	}
}
