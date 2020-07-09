package com.moth.webservice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	
	@Builder
	public MemberEntity(String email, String password) {
		this.email = email;
		this.password = password;
	}
}