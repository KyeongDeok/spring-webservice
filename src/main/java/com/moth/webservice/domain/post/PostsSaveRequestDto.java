package com.moth.webservice.domain.post;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostsSaveRequestDto {

	private String title;
	
	private String content;
	
	private String author;
	
	@Builder
	public PostsSaveRequestDto(String title, String content, String author) {
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
