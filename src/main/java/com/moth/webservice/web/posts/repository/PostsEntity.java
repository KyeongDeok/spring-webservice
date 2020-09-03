package com.moth.webservice.web.posts.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.moth.webservice.web.common.domain.BaseTimeEntity;
import com.moth.webservice.web.posts.dto.PostsSaveRequestDTO;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(	name="posts")
public class PostsEntity extends BaseTimeEntity {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 500, nullable = false)
	private String title;
	
	@Column(columnDefinition = "TEXT", nullable = false)
	private String content;
	
	private String author;
	
	public void updatePostsEntity(PostsSaveRequestDTO dto) {
		this.title = dto.getTitle();
		this.content = dto.getContent();
	}
	
	@Builder
	public PostsEntity(String title, String content, String author) {
		this.title = title;
        this.content = content;
        this.author = author;
	}
}
