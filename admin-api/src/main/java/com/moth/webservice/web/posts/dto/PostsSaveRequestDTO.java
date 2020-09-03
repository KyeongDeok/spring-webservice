package com.moth.webservice.web.posts.dto;

import com.moth.webservice.web.posts.repository.PostsEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostsSaveRequestDTO {

	private String title;
	
	private String content;
	
	private String author;
	
	@Builder
	public PostsSaveRequestDTO(String title, String content, String author) {
		this.title = title;
		this.content = content;
		this.author = author;
	}
	
	public PostsEntity toEntity() {
		return PostsEntity.builder().title(this.title).content(this.content).author(this.author).build();
	}
	
	@Override
	public String toString() {
		return "PostsSaveRequestDto [title=" + title + ", content=" + content + ", author=" + author + "]";
	}
}
