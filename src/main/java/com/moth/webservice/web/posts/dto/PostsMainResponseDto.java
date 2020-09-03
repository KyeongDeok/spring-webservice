package com.moth.webservice.web.posts.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import com.moth.webservice.web.posts.repository.PostsEntity;

import lombok.Getter;

@Getter
public class PostsMainResponseDto {
	
	private Long id;
	private String title;
	private String content;
	private String author;
	private String modifiedDate;
	
	public PostsMainResponseDto(PostsEntity entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.content = entity.getContent();
		this.author = entity.getAuthor();
		this.modifiedDate = toStringDateTime(entity.getModifiedDate());
	}
	
	/**
     * Java 8 버전
     */
    private String toStringDateTime(LocalDateTime localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(localDateTime)
                .map(formatter::format)
                .orElse("");
    }
    
}
