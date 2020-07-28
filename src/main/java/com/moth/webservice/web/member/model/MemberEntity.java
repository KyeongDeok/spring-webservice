package com.moth.webservice.web.member.model;

import javax.persistence.*;

import com.moth.webservice.web.common.domain.BaseTimeEntity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(	name="member")
public class MemberEntity extends BaseTimeEntity {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 100, nullable = false, unique=true)
	private String email;
	
	@Column(length = 100, nullable = false)
	private String password;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Role role;

	@Builder
	public MemberEntity(String email, String password) {
		this.email = email;
		this.password = password;
	}
}
