package com.moth.webservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PostsSaveRequestDto {
	private String title;
	
	private String content;
	
	private String author;
	
	public Posts toEntity() {
		return Posts.builder().title(this.title).content(this.content).author(this.author).build();
	}
}
